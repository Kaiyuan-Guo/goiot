package pers.gky.data.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pers.gky.common.utils.MapstructUtils;
import pers.gky.data.dao.ProductMapper;
import pers.gky.data.entity.Product;
import pers.gky.data.manager.IProductData;
import pers.gky.data.service.IProductService;
import pers.gky.model.product.ProductDTO;

/**
 * <p>
 * 产品 服务实现类
 * </p>
 *
 * @author gky
 * @since 2024-05-05
 */
@Primary
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductData, IProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductDTO save(ProductDTO data) {
        productMapper.insert(MapstructUtils.convert(data, Product.class));
        return data;
    }


    @Override
    public ProductDTO findByProductKey(String productKey) {
        LambdaQueryWrapper<Product> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Product::getProductKey,productKey);
        return MapstructUtils.convert(productMapper.selectOne(queryWrapper),ProductDTO.class);
    }

    @Override
    public void delByProductKey(String productKey) {

    }

}
