package com.nirrattner.pitch.core.util;

import com.google.common.base.Predicates;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class ListRemover {

  @Inject
  public ListRemover() {
  }

  public <T> List<T> remove(List<T> list, T element) {
    return list.stream()
        .filter(Predicates.not(element::equals))
        .collect(Collectors.toList());
  }
}
