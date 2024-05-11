package pers.gky.data.manager;

import pers.gky.data.ICommonData;
import pers.gky.model.product.ProductDTO;

/**
 * @author gky
 * @date 2024/05/10 10:51
 * @description 产品接口
 */
public interface IProductData extends ICommonData<ProductDTO,Long> {
    ProductDTO findByProductKey(String productKey);

    void delByProductKey(String productKey);
}
