/*******************************************************************************
 *
 * Pentaho Big Data
 *
 * Copyright (C) 2002-2020 by Hitachi Vantara : http://www.pentaho.com
 *
 *******************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package org.pentaho.amazon;

import org.pentaho.amazon.s3.S3AVfsFileChooserDialog;
import org.pentaho.amazon.s3.S3NVfsFileChooserDialog;
import org.pentaho.di.core.annotations.LifecyclePlugin;
import org.pentaho.di.core.gui.GUIOption;
import org.pentaho.di.core.lifecycle.LifeEventHandler;
import org.pentaho.di.core.lifecycle.LifecycleException;
import org.pentaho.di.core.lifecycle.LifecycleListener;
import org.pentaho.di.ui.spoon.Spoon;
import org.pentaho.vfs.ui.VfsFileChooserDialog;

@LifecyclePlugin( id = "AmazonSpoonPlugin", name = "Amazon Spoon Plugin EE" )
public class AmazonSpoonPlugin implements LifecycleListener, GUIOption<Object> {

  private static final int S_3_N_PRIORITY = 120;
  private static final int S_3_A_PRIORITY = 125;

  public void onStart( LifeEventHandler arg0 ) throws LifecycleException {
    VfsFileChooserDialog dialog = Spoon.getInstance().getVfsFileChooserDialog( null, null );
    Spoon.getInstance().getVfsFileChooserDialog( null, null )
      .addVFSUIPanel( S_3_N_PRIORITY, new S3NVfsFileChooserDialog( dialog, null, null ) );
    Spoon.getInstance().getVfsFileChooserDialog( null, null )
      .addVFSUIPanel( S_3_A_PRIORITY, new S3AVfsFileChooserDialog( dialog, null, null ) );
  }

  public void onExit( LifeEventHandler arg0 ) throws LifecycleException {
  }

  public String getLabelText() {
    return null;
  }

  public Object getLastValue() {
    return null;
  }

  public DisplayType getType() {
    return null;
  }

  public void setValue( Object value ) {
  }
}
