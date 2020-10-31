package sn.senforage.test;

import sn.senforage.dao.JpaRepository;
import sn.senforage.dao.VillageRepository;
import sn.senforage.entities.Village;

public class Main {

	public static void main(String[] args) {
		JpaRepository<Village> villagedao = new VillageRepository();
		
		Village v = new Village();
		
		v.setNomVillage("THioubalele");
		villagedao.add(v);
	}

}
