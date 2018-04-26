/*
 * Copyright 2012-present Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.facebook.buck.rules;

import com.facebook.buck.core.util.immutables.BuckStyleImmutable;
import com.google.common.base.Preconditions;
import org.immutables.value.Value;

@Value.Immutable(intern = true)
@BuckStyleImmutable
abstract class AbstractBuildRuleType {

  /** @return the name as displayed in a build file, such as "java_library" */
  @Value.Parameter
  public abstract String getName();

  @Value.Derived
  public boolean isTestRule() {
    return getName().endsWith("_test");
  }

  @Value.Check
  protected void check() {
    String name = getName();
    Preconditions.checkArgument(name.toLowerCase().equals(name));
  }

  @Override
  public String toString() {
    return getName();
  }
}
