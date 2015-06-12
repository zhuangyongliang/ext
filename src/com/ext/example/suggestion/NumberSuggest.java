package com.ext.example.suggestion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import wt.fc.PersistenceHelper;
import wt.fc.QueryResult;
import wt.part.WTPartMaster;
import wt.query.QuerySpec;
import wt.query.SearchCondition;
import wt.util.WTException;

import com.ptc.core.components.suggest.SuggestParms;
import com.ptc.core.components.suggest.SuggestResult;
import com.ptc.core.components.suggest.Suggestable;

public class NumberSuggest implements Suggestable {
    @Override
    public Collection<SuggestResult> getSuggestions(SuggestParms suggestParams) { // Override function
        List<SuggestResult> list = new ArrayList<SuggestResult>();
        try {
        String partNumber = suggestParams.getSearchTerm().toUpperCase() + "%";
        QuerySpec spec = new QuerySpec(WTPartMaster.class);
        SearchCondition sc = new SearchCondition(WTPartMaster.class, WTPartMaster.NUMBER, 
                SearchCondition.LIKE, partNumber, false);
        spec.appendWhere(sc, new int[]{0});
        QueryResult result = PersistenceHelper.manager.find(spec);
        WTPartMaster oneMaster = null;
        while(result.hasMoreElements()) {
            oneMaster = (WTPartMaster)result.nextElement();
            list.add(SuggestResult.valueOf(oneMaster.getNumber(), oneMaster.getName()));
        }
        } catch(WTException wte) {
            wte.printStackTrace();
        }
        return list;
    }
       

}
