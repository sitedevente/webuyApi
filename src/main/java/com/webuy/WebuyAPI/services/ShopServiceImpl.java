package com.webuy.WebuyAPI.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webuy.WebuyAPI.dao.AddressJPARepository;
import com.webuy.WebuyAPI.dao.ImagesPointerJPARepository;
import com.webuy.WebuyAPI.dao.ShopJPARepository;
import com.webuy.WebuyAPI.entities.ImagesPointer;
import com.webuy.WebuyAPI.entities.Shop;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	ShopJPARepository repo;
	@Autowired
	ImagesPointerJPARepository imagesRepo;

	@Autowired
	AddressJPARepository addressRepo;

	@Override
	public Collection<Shop> getAll() {
		return repo.findAll();
	}

	@Override
	public Shop getOne(Long id) {
		Shop shop = null;

		Optional<Shop> optShop = repo.findById(id);
		if (optShop.isPresent()) {
			shop = repo.findById(id).get();
		}

		return shop;
	}

	@Override
	public void createShop(Shop newShop) {
		repo.save(newShop);
	}

	@Override
	public void updateShop(Long id, Shop newShop) {
		repo.findById(id).ifPresent(shop -> {
			shop.setAddress(newShop.getAddress());
			shop.setImages(newShop.getImages());
			shop.setShopGroup(newShop.getShopGroup());
			shop.setProducts(newShop.getProducts());
			shop.setOffers(newShop.getOffers());
			repo.save(shop);
		});
	}

	@Override
	public void deleteShop(Long id) {
		//Long imagesId = getOne(id).getImages().getId();
		//imagesRepo.findById(imagesId).ifPresent(images -> imagesRepo.deleteById(imagesId));
		//imagesRepo.delete(getOne(id).getImages());
		repo.findById(id).ifPresent(shop -> repo.deleteById(id));
		
	}
}
