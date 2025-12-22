/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.iceberg.exceptions;

import com.google.errorprone.annotations.FormatMethod;

/** Base class for REST client exceptions */
public class RESTException extends RuntimeException {
  private final Integer statusCode;

  @FormatMethod
  public RESTException(String message, Object... args) {
    this(null, null, message, args);
  }

  @FormatMethod
  public RESTException(Throwable cause, String message, Object... args) {
    this(null, cause, message, args);
  }

  @FormatMethod
  public RESTException(Integer statusCode, String message, Object... args) {
    this(statusCode, null, message, args);
  }

  @FormatMethod
  public RESTException(Integer statusCode, Throwable cause, String message, Object... args) {
    super(String.format(message, args), cause);
    this.statusCode = statusCode;
  }

  /** Returns the HTTP status code associated with this exception, or null if not available. */
  public Integer statusCode() {
    return statusCode;
  }
}
