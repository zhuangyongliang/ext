package com.acme;

import wt.doc.WTDocument;
import wt.util.WTException;
import com.ptc.windchill.annotations.metadata.*;

@GenAsPersistable(
    superClass=WTDocument.class,
    properties={
        @GeneratedProperty(name="sizeC", type=Integer.class, initialValue="3",
                           javaDoc="Integer value to represent the size of C.")
    },
    iconProperties=@IconProperties(standardIcon="netmarkets/images/stop.gif",openIcon="netmarkets/images/stop.gif")
)
public class AcmeModeledDoc extends _AcmeModeledDoc {
    static final long serialVersionUID = 1;
    public static AcmeModeledDoc newAcmeModeledDoc() throws WTException {
        AcmeModeledDoc instance = new AcmeModeledDoc();
        instance.initialize();
        return instance;
    }
}
