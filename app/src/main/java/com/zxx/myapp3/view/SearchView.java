package com.zxx.myapp3.view;

import com.zxx.myapp3.entity.SearchBean;

/**
 * 搜搜好友的View
 */

public interface SearchView {
    void searchSuccess(SearchBean value);
    void searchFailure(String msg);

}
