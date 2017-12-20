package com.zxx.myapp3.dagger2;

import com.zxx.myapp3.activity.GuanActivity;
import com.zxx.myapp3.activity.LoginActivity;
import com.zxx.myapp3.activity.Main2Activity;
import com.zxx.myapp3.activity.SSActivity;
import com.zxx.myapp3.fragment.Fragment1;

import dagger.Component;

/**
 *Dagger2
 */

@Component(modules = MyModule.class)//关联VideoModule
public interface MyComponent {

    void inject(LoginActivity loginActivity);

    void inject(Main2Activity main2Activity);

    void inject(GuanActivity guanActivity);

    void inject(SSActivity ssActivity);

    void inject(Fragment1 fragment1);


}
