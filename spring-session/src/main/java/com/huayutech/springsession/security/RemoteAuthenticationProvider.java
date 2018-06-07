/*
 * Copyright 2018 Huayu Software Technology Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.huayutech.springsession.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class RemoteAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if (authentication instanceof UsernamePasswordAuthenticationToken) {

            UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;

            String userName = (String)token.getPrincipal();
            String password = (String)token.getCredentials();

            if (userName.equals("1") && password.equals("1")) {

                return new UsernamePasswordAuthenticationToken(token.getPrincipal(), token.getCredentials(), null);
            }

        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}
