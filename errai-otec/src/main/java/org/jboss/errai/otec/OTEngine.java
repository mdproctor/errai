/*
 * Copyright 2013 JBoss, by Red Hat, Inc
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

package org.jboss.errai.otec;


import org.jboss.errai.otec.operation.OTOperation;
import org.jboss.errai.otec.operation.OTOperationsFactory;

/**
 *
 * @author Christian Sadilek <csadilek@redhat.com>
 * @author Mike Brock
 */
public interface OTEngine {
  public String getId();

  public InitialStateReceiveHandler getInitialStateReceiveHandler(String peerId, int entityId);

  public void syncRemoteEntity(String peerId, int entityId, EntitySyncCompletionCallback callback);

  public void notifyOperation(OTOperation operation);

  public OTEntityState getEntityStateSpace();

  public OTOperationsFactory getOperationsFactory();

  public void associateEntity(String peerId, int entityId);

  public void disassociateEntity(String peerId, int entityId);

  public void registerPeer(OTPeer peer);

  public String getName();

  void start();

  void stop(boolean wait);

  void receive(String peerId, int entityId, OTOperation remoteOp);
}
