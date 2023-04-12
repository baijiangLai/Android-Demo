package com.example.demo2.model;

import com.example.demo2.bean.Mobile;

import io.reactivex.Observable;

/**
 * @author laibaijiang
 * @date 2023/4/12
 */
public interface IMobile {
    Observable<Mobile> search(String num);
}
