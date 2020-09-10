/*
 * Copyright (c) 2020 Vonage
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.vonage.client.verify;

import com.vonage.client.HttpWrapper;
import com.vonage.client.VonageClientException;

import java.util.Locale;

class VerifyEndpoint {
    private VerifyMethod verifyMethod;

    VerifyEndpoint(HttpWrapper httpWrapper) {
        this.verifyMethod = new VerifyMethod(httpWrapper);
    }

    VerifyResponse verify(String number, String brand, String from, int length, Locale locale, VerifyRequest.LineType type) throws VonageClientException {
        return verify(new VerifyRequest.Builder(number, brand)
                .senderId(from)
                .locale(locale)
                .type(type)
                .build()
        );
    }

    VerifyResponse verify(String number, String brand, String from, int length, Locale locale) throws VonageClientException {
        return verify(new VerifyRequest.Builder(number, brand)
                .senderId(from)
                .locale(locale)
                .build()
        );
    }

    VerifyResponse verify(String number, String brand, String from) throws VonageClientException {
        return verify(new VerifyRequest.Builder(number, brand)
                .senderId(from)
                .build()
        );
    }

    VerifyResponse verify(String number, String brand) throws VonageClientException {
        return verify(new VerifyRequest.Builder(number, brand).build());
    }

    VerifyResponse verify(String number, String brand, VerifyRequest.Workflow workflow) throws VonageClientException {
        return verify(
                new VerifyRequest.Builder(number, brand)
                        .workflow(workflow)
                        .build()
        );
    }

    VerifyResponse verify(VerifyRequest request) throws VonageClientException {
        return this.verifyMethod.execute(request);
    }
}