package com.api.books.service;

import com.google.gson.Gson;

public class ConvertInJson implements IConvertJson {
    private final Gson gson = new Gson();

    @Override
    public <T> T getData(String json, Class<T> tClass) {
        return gson.fromJson(json, tClass);
    }
}
