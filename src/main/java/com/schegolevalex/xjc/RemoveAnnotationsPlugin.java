package com.schegolevalex.xjc;

import com.sun.tools.xjc.Options;
import com.sun.tools.xjc.Plugin;
import com.sun.tools.xjc.outline.Outline;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

public class RemoveAnnotationsPlugin extends Plugin {
    public String getOptionName() {
        return "XRemoveAnnotationsPlugin";
    }

    public String getUsage() {
        return "  -XRemoveAnnotationsPlugin    :  xjc plugin for remove all annotations from generated jaxb files";
    }

    public boolean run(Outline outline, Options options, ErrorHandler errorHandler) throws SAXException {








        return false;
    }
}
