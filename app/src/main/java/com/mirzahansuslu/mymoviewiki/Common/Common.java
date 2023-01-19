package com.mirzahansuslu.mymoviewiki.Common;

import com.mirzahansuslu.mymoviewiki.Network.APIService;
import com.mirzahansuslu.mymoviewiki.Network.RetrofitInstance;

public class Common {
    private static final String BASE_URL = "https://www.simplifiedcoding.net/demos/";
    public static APIService getAPIService() {
        return RetrofitInstance.getRetrofitClient(BASE_URL).create(APIService.class);

    }

}
