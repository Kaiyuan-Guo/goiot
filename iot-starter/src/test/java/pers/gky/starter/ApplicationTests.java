package pers.gky.starter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.gky.data.dao.ProductMapper;
import pers.gky.data.dao.ThingModelMapper;
import pers.gky.data.entity.Product;
import pers.gky.data.entity.ThingModel;

/**
 * @author gky
 * @date 2024/05/13 20:43
 * @description
 */
@SpringBootTest
public class ApplicationTests {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ThingModelMapper thingModelMapper;
    @Test
    void addProduct(){
        Product product=new Product();
        product.setCreateAt(System.currentTimeMillis());
        product.setImg("http://iotkit-img.oss-cn-shenzhen.aliyuncs.com/product/cGCrkK7Ex4FESAwe/cover.jpeg?Expires=1967598137&OSSAccessKeyId=LTAI5tGEHNoVu5tWHUWnosrs&Signature=vOjqav0pRZqQFgx8xBo99WhgWXk%3D");
        product.setIsOpenLocate(false);
        product.setName("插座");
        product.setNodeType(1);
        product.setProductKey("cGCrkK7Ex4FESAwe");
        product.setProductSecret("xdkKUymrEGSCYWswqCvSPyRSFvH5j7CU");
        product.setTransparent(false);
        product.setUid("1");
        productMapper.insert(product);
    }
    @Test
    void addThingModel(){
        ThingModel thingModel=new ThingModel();
        thingModel.setModel("{\"properties\":[{\"identifier\":\"rssi\",\"dataType\":{\"type\":\"int32\",\"specs\":{\"min\":\"-127\",\"max\":\"127\"}},\"name\":\"信号强度\",\"accessMode\":\"r\",\"description\":null,\"unit\":null},{\"identifier\":\"DeviceType\",\"dataType\":{\"type\":\"text\",\"specs\":{\"length\":\"128\"}},\"name\":\"设备型号\",\"accessMode\":\"r\",\"description\":null,\"unit\":null},{\"identifier\":\"powerstate\",\"dataType\":{\"type\":\"bool\",\"specs\":{\"0\":\"关\",\"1\":\"开\"}},\"name\":\"开关\",\"accessMode\":\"rw\",\"description\":null,\"unit\":null}],\"services\":[{\"identifier\":\"Toggle\",\"inputData\":[],\"outputData\":[],\"name\":\"开关切换\"}],\"events\":[{\"identifier\":\"faultReportEvent\",\"outputData\":[{\"identifier\":\"code\",\"dataType\":{\"type\":\"int32\",\"specs\":{\"min\":\"0\",\"max\":\"255\"}},\"name\":\"错误代码\",\"required\":false}],\"name\":\"故障上报\"}]}");
        thingModel.setProductKey("cGCrkK7Ex4FESAwe");
        thingModelMapper.insert(thingModel);
    }

}























