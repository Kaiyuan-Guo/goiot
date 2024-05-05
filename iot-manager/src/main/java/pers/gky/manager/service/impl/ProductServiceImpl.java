package pers.gky.manager.service.impl;

import pers.gky.manager.model.entity.Product;
import pers.gky.manager.dao.ProductMapper;
import pers.gky.manager.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品 服务实现类
 * </p>
 *
 * @author gky
 * @since 2024-05-05
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
