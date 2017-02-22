/*
 * Copyright (C) 2017.  BoBoMEe(wbwjx115@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.bobomee.android.common.mvp;

import android.content.Context;

/**
 * Base Contract for MVP
 */

public interface BaseContract {
  /**
   * Interface representing a Presenter in a model view presenter (MVP) pattern.
   */
  public interface MvpPresenter<V extends MvpView> extends BasePresenter {

    void attachView(V view);

    void detachView(boolean retainInstance);

    V getView();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onResume() method.
     */
    void resume();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onPause() method.
     */
    void pause();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onDestroy() method.
     */
    void destroy();
  }

  public interface BasePresenter {

    void initialize(boolean update);
  }

  /**
   * Created on 2016/12/3.下午4:04.
   *
   * @author bobomee.
   * @description
   */

  public interface MvpView<T extends BasePresenter> {

    /**
     * Get a {@link Context}.
     */
    Context context();

    void setPresenter(T presenter);
  }
}
