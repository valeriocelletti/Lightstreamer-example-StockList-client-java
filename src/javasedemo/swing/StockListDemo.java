/*
 * Copyright 2013 Weswit Srl
 *
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
 */
 
package javasedemo.swing;

import javax.swing.SwingUtilities;

public class StockListDemo {

    private static final long serialVersionUID = 1L;

    
    /**
     * @param args
     */
    public static void main(final String[] args) {
        //args[0] should contain the hostname of the Lightstreamer server.
        //args[1] should contain the port the Lightstreamer server is listening to. 
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //the StockView instance will handle the JTable that shows the data
                StockView view = new StockView();
                view.initialize();
                //the StockFeed instance will connect to a Lightstreamer server, will subscribe to a set of items 
                //and will store the received data
                StockFeed feed = new StockFeed(args[0],Integer.parseInt(args[1]), view);
                feed.start();
            }
        });
    }

    
} 
