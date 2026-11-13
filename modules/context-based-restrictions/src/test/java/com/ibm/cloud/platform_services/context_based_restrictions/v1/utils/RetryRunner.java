/*
 * (C) Copyright IBM Corp. 2026.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.cloud.platform_services.context_based_restrictions.v1.utils;

/**
 * Retries a Runnable until it completes without throwing, or until a timeout elapses.
 *
 * <pre>
 * new RetryRunner()
 *     .timeoutMillis(30000)
 *     .intervalMillis(1000)
 *     .run(() -> doSomething());
 * </pre>
 */
public class RetryRunner {
    private long timeoutMillis = 30000;
    private long intervalMillis = 1000;

    public RetryRunner timeoutMillis(long timeoutMillis) {
        this.timeoutMillis = timeoutMillis;
        return this;
    }

    public RetryRunner timeoutSeconds(long timeoutSeconds) {
        return timeoutMillis(timeoutSeconds * 1000);
    }

    public RetryRunner intervalMillis(long intervalMillis) {
        this.intervalMillis = intervalMillis;
        return this;
    }

    public RetryRunner intervalSeconds(long intervalSeconds) {
        return intervalMillis(intervalSeconds * 1000);
    }

    /**
     * Runs the Runnable, retrying whenever it throws, waiting intervalMillis between attempts.
     * Each failure is logged. If the timeout elapses, the last exception is rethrown wrapped
     * in a RuntimeException.
     */
    public void run(Runnable runnable) {
        final long start = System.currentTimeMillis();
        final long timeoutTime = start + timeoutMillis;
        int attempt = 0;
        while (true) {
            attempt++;
            try {
                runnable.run();
                if (attempt > 1) {
                    System.out.println("All attempts together took " + getElapsedSeconds(start) + " seconds.");
                }
                return;
            } catch (Exception | AssertionError e) {
                System.out.println("Attempt " + attempt + " failed: " + e.getMessage());
                if (System.currentTimeMillis() > timeoutTime) {
                    System.out.println("Timed out after " + getElapsedSeconds(start) + " seconds and " + attempt + " attempt(s)");
                    throw e;
                }
                try {
                    Thread.sleep(intervalMillis);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Interrupted while waiting to retry", ie);
                }
            }
        }
    }

    private static long getElapsedSeconds(long startMillis) {
        return (System.currentTimeMillis() - startMillis) / 1000;
    }
}
