package com.earl.fishshop.domain.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.domain.base.BaseServiceImpl;
import com.earl.fishshop.domain.comment.CommentPo;
import com.earl.fishshop.domain.farmers.FarmersPo;
import com.earl.fishshop.domain.fishman.FishmanPo;
import com.earl.fishshop.domain.gettype.GetTypeService;
import com.earl.fishshop.domain.searecord.SeaRecordPo;
import com.earl.fishshop.domain.user.UserPo;
import com.earl.fishshop.util.MyConstant;
import com.earl.fishshop.vo.PageInfo;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
@Service(value = "shopService")
public class ShopServiceImpl extends BaseServiceImpl<ShopPo> implements
		ShopService {

	@Resource(name = "shopDao")
	ShopDao shopDao;

	@PostConstruct
	public void initBaseDao() {
		baseDao = shopDao;
	}
	
	@Resource
	protected GetTypeService getTypeServer;

	@Override
	public ShopPo getMyShop(Long userId) {
		ShopPo shop = shopDao.getMyShop(userId);
		return shop;
	}

	@Override
	public Boolean updateSentPrice(Long shopId, Double sendPrice) {
		try {
			shopDao.updateSentPrice(shopId, sendPrice);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean addShop(ShopPo model) {
		try {
			UserPo userPo = userDao.get(model.getUserId());
			if (userPo.getUserType() == MyConstant.user_farmer) {
				FarmersPo farmers = farmersDao.get(userPo.getIdentityId());
				model.setGetType(farmers.getMultiGetType());
				model.setAddress(farmers.getAddress());
				model.setLongitude(farmers.getLongitude());
				model.setLatitude(farmers.getLatitude());
				model.setShopType(MyConstant.shop_farmerman);
				model.setOnSell(MyConstant.shop_onSell);
				model.setShopType(MyConstant.shop_farmerman);
				Long shopId = shopDao.addShop(model);
				farmers.setShopId(shopId);
				farmersDao.update(farmers);
			} else if (userPo.getUserType() == MyConstant.user_fishman) {
				FishmanPo fishman = fishmanDao.get(userPo.getIdentityId());
				model.setShopType(MyConstant.shop_fishman);
				model.setGetType(String.valueOf(fishman.getGetType()));
				model.setShopType(MyConstant.shop_fishman);
				model.setOnSell(MyConstant.shop_notOnSell);
				Long shopId = shopDao.addShop(model);
				fishman.setShopId(shopId);
				fishmanDao.update(fishman);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean endSeaing(Long shopId) {
		// TODO 未测试.
		try {
			ShopPo shopPo = shopDao.get(shopId);
			shopPo.setOnSell(MyConstant.shop_notOnSell);
			shopPo.setSeaRecordId(null);
			shopDao.update(shopPo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void updateShopComment(CommentPo model) {
		List<CommentPo> list = commentDao.getShopComment(model.getShopId());
		int i = list.size();
		ShopPo shop = shopDao.get(model.getShopId());
		System.out.println(shop.getFreshQuality().getClass());
		System.out.println(shop.getFreshQuality() + "-----"
				+ shop.getFreshQuality() * (i - 1));
		System.out.println(model.getFreshQuality().getClass());
		System.out.println(model.getFreshQuality() + shop.getFreshQuality());
		Float newFreshQuality = new Float(
				(shop.getFreshQuality() * (i - 1) + model.getFreshQuality())
						/ i);
		Float newSpeedQuality = new Float(
				(shop.getSpeedQuality() * (i - 1) + model.getSpeedQuality())
						/ i);
		Float newWeightQuality = new Float(
				(shop.getWeightQuality() * (i - 1) + model.getWeightQuality())
						/ i);
		shop.setFreshQuality(newFreshQuality);
		shop.setSpeedQuality(newSpeedQuality);
		shop.setWeightQuality(newWeightQuality);
		System.out.println("---------------------------------");
		shop.setGrade(shop.getGrade() + model.getCommentType());
		shopDao.updateShop(shop);

	}

	@Override
	public Map<String, Object> getShopCommentInfo(Long shopId) {
		ShopPo shop = shopDao.get(shopId);
		int commentSizt = commentDao.getShopComment(shopId).size();
		int goodComment = commentDao.getGoodComment(shopId).size();
		int midComment = commentDao.getMidComment(shopId).size();
		int bedComment = commentDao.getBedComment(shopId).size();
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("shop", shop); // 商店信息：新鲜度、足斤足称、发货速度
		hashMap.put("commentSize", commentSizt); // 全部评论数量
		hashMap.put("goodComment", goodComment);// 好评数量
		hashMap.put("midComment", midComment); // 中评数量
		hashMap.put("bedComment", bedComment); // 差评数量

		return hashMap;
	}

	@Override
	public List<Map<String, Object>> getAllFishmanShop() {
		Map<String, Object> map = new HashMap<String, Object>();//存放一条信息
		List<Map<String,Object>> infoList = new ArrayList<Map<String,Object>>();//存放全部信息.
		List<FishmanPo> fishmanList = fishmanDao.findAll();
		for (FishmanPo fishman : fishmanList) {
			if (fishman.getShopId() != null) {
				ShopPo shop = shopDao.get(fishman.getShopId());
				map.put("fishmanId", fishman.getFishmanId());
				map.put("shopId", fishman.getShopId());
				String getName = getTypeServer.getGetTypeName(shop.getGetType());
				map.put("getName", getName);
				map.put("createTime", fishman.getCreateTime());
				infoList.add(map);
			}
		}
		return infoList;
	}

	@Override
	public List<Map<String, Object>> getAllFarmersShop() {
		Map<String, Object> map = new HashMap<String, Object>();//存放一条信息
		List<Map<String,Object>> infoList = new ArrayList<Map<String,Object>>();//存放全部信息.
		List<FarmersPo> farmersList = farmersDao.findAll();
		for (FarmersPo farmers : farmersList) {
			if (farmers.getShopId() != null) {
				ShopPo shop = shopDao.get(farmers.getShopId());
				map.put("farmersId", farmers.getFarmersId());
				map.put("shopId", farmers.getShopId());
				String getName = getTypeServer.getGetTypeName(shop.getGetType());
				map.put("getName", getName);
				map.put("shopName", shop.getShopName());
				map.put("createTime", shop.getCreateTime());
				infoList.add(map);
			}
		}
		return infoList;
	}

	@Override
	public List<ShopPo> getAllShop(PageInfo pageInfo) {
		List<ShopPo> shopList = shopDao.getAllShop(pageInfo);
		return shopList;
	}

	@Override
	public ShopPo getShop(Long shopId) {
		// TODO 未测试.
		ShopPo shop = shopDao.get(shopId);
		if(shop.getSeaRecordId() != null){
			SeaRecordPo seaRecordPo = seaRecordDao.get(shop.getSeaRecordId());
			shop.setShipPort(seaRecordPo.getShipportName());
			shop.setPortTime(seaRecordPo.getEndSeeTime());
		}
		return shop;
	}
	
	

}
