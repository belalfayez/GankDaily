/*
 * Copyright (C) 2016.  BoBoMEe(wbwjx115@gmail.com)
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

package com.bobomee.android.data.repo;

import com.bobomee.android.data.Repository;
import com.bobomee.android.htttp.bean.GankCategory;
import com.bobomee.android.domain.executor.PostExecutionThread;
import com.bobomee.android.domain.executor.ThreadExecutor;
import com.bobomee.android.domain.interactor.UseCase;
import io.rx_cache.Reply;
import javax.inject.Inject;
import rx.Observable;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for login and
 * retrieve a {@link GankCategory}.
 */
public class Category extends UseCase<GankCategory, Category.Params> {

  private final Repository mRepository;

  @Override
  protected Observable<GankCategory> buildUseCaseObservable(Params params, boolean update) {
    return this.mRepository.getCategoryData(params.mCategory, params.mCount, params.mPage, update)
        .map(Reply::getData);
  }

  public static final class Params {

    private String mCategory;
    private Integer mCount;
    private Integer mPage;

    public Params(String category, Integer count, Integer page) {
      this.mCategory = category;
      this.mCount = count;
      this.mPage = page;
    }

    public static Category.Params forParams(String category, Integer count, Integer page) {
      return new Category.Params(category, count, page);
    }
  }

  @Inject public Category(Repository reposRepository, ThreadExecutor threadExecutor,
      PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
    this.mRepository = reposRepository;
  }
}
