package service;

import model.Category;

public interface CategoryService extends GeneralService<Category> {
    public Category findName(String name);
}
