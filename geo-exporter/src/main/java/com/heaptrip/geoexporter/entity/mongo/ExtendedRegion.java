package com.heaptrip.geoexporter.entity.mongo;

public class ExtendedRegion extends Region {

	// id in the geo.webnabor.com
	private String geoWNId;
	
	// id in the geonames.org
	private String geoNId;

	// population of the region
	private Integer population;
	
	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public String getGeoWNId() {
		return geoWNId;
	}

	public void setGeoWNId(String geoWNId) {
		this.geoWNId = geoWNId;
	}

	public String getGeoNId() {
		return geoNId;
	}

	public void setGeoNId(String geoNId) {
		this.geoNId = geoNId;
	}
}
