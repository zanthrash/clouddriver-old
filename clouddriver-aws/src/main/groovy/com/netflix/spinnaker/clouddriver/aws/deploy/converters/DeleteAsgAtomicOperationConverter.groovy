/*
 * Copyright 2014 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.clouddriver.aws.deploy.converters

import com.netflix.spinnaker.clouddriver.orchestration.AtomicOperation
import com.netflix.spinnaker.clouddriver.security.AbstractAtomicOperationsCredentialsSupport
import com.netflix.spinnaker.clouddriver.aws.deploy.description.DeleteAsgDescription
import com.netflix.spinnaker.clouddriver.aws.deploy.ops.DeleteAsgAtomicOperation
import org.springframework.stereotype.Component

@Component("deleteAsgDescription")
class DeleteAsgAtomicOperationConverter extends AbstractAtomicOperationsCredentialsSupport {
  AtomicOperation convertOperation(Map input) {
    new DeleteAsgAtomicOperation(convertDescription(input))
  }

  DeleteAsgDescription convertDescription(Map input) {
    def converted = objectMapper.convertValue(input, DeleteAsgDescription)
    converted.credentials = getCredentialsObject(input.credentials as String)
    converted
  }
}
