/**
 * Copyright 2015 SPeCS.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License. under the License.
 */

package pt.up.fe.specs.xstreamplus;

import java.io.File;

import pt.up.fe.specs.library.IoUtils;

import com.thoughtworks.xstream.XStream;

public class XStreamUtils {

    /**
     * Helper method for XStream 'fromXML'. This version is unsafe, if the output class is not the same as the file
     * being read, throws an exception (ClassCastException?).
     * 
     * @param file
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T read(File file) {
	return (T) new XStream().fromXML(file);
    }

    /**
     * Converts an object to XML and then writes it to a file.
     * 
     * @param file
     * @return
     */
    public static void write(Object contents, File file) {
	IoUtils.write(toString(contents), file);
    }

    /**
     * Helper method for XStream 'toXML'.
     * 
     * @param contents
     * @return
     */
    public static String toString(Object contents) {
	return new XStream().toXML(contents);
    }
}