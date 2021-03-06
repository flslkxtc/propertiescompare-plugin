/*
 * Copyright (c) 2017 Stanislav Myachenkov
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */
package org.propertiescompare.main.ui.actions;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Pair;
import com.intellij.ui.components.JBList;
import org.propertiescompare.main.compare.PropertyFile;

import java.util.ArrayList;
import java.util.List;

public class FileActionContext {
  private Project project;
  private PropertyFile startFile;
  private JBList<PropertyFile> files;

  public FileActionContext(Project project, PropertyFile startFile, JBList<PropertyFile> files) {
    this.project = project;
    this.startFile = startFile;
    this.files = files;
  }

  public Project getProject() {
    return project;
  }

  public Pair<PropertyFile, PropertyFile> getComparedFiles() {
    return new Pair<>(startFile, files.getSelectedValue());
  }

  public JBList<PropertyFile> getFiles() {
    return files;
  }

  public List<PropertyFile> getFilesAsList() {
    List<PropertyFile> fileList = new ArrayList<>();
    for (int i = 0; i < files.getModel().getSize(); i++) {
      fileList.add(files.getModel().getElementAt(i));
    }
    return fileList;
  }
}
