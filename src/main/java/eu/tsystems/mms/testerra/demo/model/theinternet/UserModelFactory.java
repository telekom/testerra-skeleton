/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Eric Kubenka
 */

package eu.tsystems.mms.testerra.demo.model.theinternet;

/**
 * Creates predefined userobjects
 * <p>
 * Date: 14.05.2020
 * Time: 13:53
 *
 * @author Eric Kubenka
 */
public class UserModelFactory {

    public UserModel createJohnSmith() {

        final UserModel userModel = new UserModel();
        userModel.setLastName("Smith");
        userModel.setFirstName("John");

        return userModel;
    }

    public UserModel createNonExisting() {

        final UserModel userModel = new UserModel();
        userModel.setLastName("Lucas");
        userModel.setFirstName("John");

        return userModel;
    }

}
