package com.forum.jobs.application;

import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Created by DELL on 2018/7/10.
 */

public class GlobalApplicationTinker extends TinkerApplication {
    public GlobalApplicationTinker() {
        super(ShareConstants.TINKER_ENABLE_ALL, "com.forum.jobs.application.GlobalApplication", "com.tencent.tinker.loader.TinkerLoader", false);
    }
}
