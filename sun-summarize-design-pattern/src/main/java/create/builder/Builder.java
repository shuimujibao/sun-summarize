package create.builder;

/**
 * @author : itw_sunxy
 * @description builder接口负责创建套餐Meal对象
 * @createtime : 2019/6/25 16:47
 */
public interface Builder {
    void buildApple(int price);

    void buildBanana(int price);

    void buildOrange(int price);

    FruitMeal getFruitMeal();
}
