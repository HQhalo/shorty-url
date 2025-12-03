package com.shortly.shortly_url.app.usecase;

public interface UseCase<T, V> {
    T execute(V input);
}
