// The contents of this file are subject to the Mozilla Public License
// Version 1.1 (the "License"); you may not use this file except in
// compliance with the License. You may obtain a copy of the License
// at http://www.mozilla.org/MPL/
//
// Software distributed under the License is distributed on an "AS IS"
// basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See
// the License for the specific language governing rights and
// limitations under the License.
//
// The Original Code is RabbitMQ.
//
// The Initial Developer of the Original Code is VMware, Inc.
// Copyright (c) 2011 VMware, Inc.  All rights reserved.
//

package com.rabbitmq.client.rpc;

import java.io.IOException;

import com.rabbitmq.client.Channel;

/**
 * When started, a processor asynchronously listens for requests received and passes them to the
 * handler, returning a result if one is expected. Each request is processed serially.<br/>
 * When stopped, the asynchronous listening is stopped. Any in-process requests are finished before
 * stop() returns.
 * <p/>
 * <b>Concurrent Semantics</b><br/>
 * Implementations must be thread-safe and serially call the handler methods.
 */
public interface RpcProcessor {

    /**
     * Start processing requests.
     * @param channel to process requests from
     * @throws IOException if the listener fails to be started, or if the process has already been
     *             started, or the channel is not available
     */
    void start(Channel channel) throws IOException;

    /**
     * Stop listening for requests
     * @throws IOException if listening cannot be stopped, or if it stops with errors, or is already
     *             stopped.
     */
    void stop() throws IOException;

}
