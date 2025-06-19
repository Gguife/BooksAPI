package com.api.books.service;

public interface IConvertJson {
    <T> T getData(String json, Class<T> tClass);
}
