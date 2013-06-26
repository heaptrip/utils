package com.heaptrip.geoexporter.entity.mysql;

public class City {
	
	private String id;
	private String vkl; 
	private String id_gn; 
	private String status; 
	private String samonazvanie;
	private String mfa; 
	private String samonazvanie_1; 
	private String oficialno_1; 
	private String flag; 
	private String flag_svg; 
	private String gerb; 
	private String gerb_svg; 
	private String giddom; 
	private String tip; 
	private String region_id; 
	private String strana_id; 
	private String ksi1; 
	private String ksi2; 
	private String ksi_sort; 
	private String ksi_lat; 
	private String telefon; 
	private String pochta; 
	private String avto; 
	private String naselenie; 
	private String ploshad; 
	private String vysota; 
	private String osnovan; 
	private String upominanie; 
	private String kontinent; 
	private String shirota; 
	private String dolgota; 
	private String shirota_gradus; 
	private String shirota_minuta; 
	private String shirota_sekunda; 
	private String dolgota_gradus; 
	private String dolgota_minuta; 
	private String dolgota_sekunda; 
	private String sozdan; 
	private String izmenen; 
	private String vrem_pojas; 
	private String dop_nazvanie; 
	private String gn_tip_np; 
	private String nazvanie_1; 
	private String opisanie_1; 
	private String nazvanie_2; 
	private String opisanie_2; 
	private String nazvanie_3; 
	private String opisanie_3; 
	private String nazvanie_4; 
	private String opisanie_4; 
	private String nazvanie_5; 
	private String opisanie_5; 
	private String nazvanie_6; 
	private String opisanie_6; 
	private String nazvanie_7; 
	private String opisanie_7; 
	private String nazvanie_8; 
	private String opisanie_8; 
	private String nazvanie_9; 
	private String opisanie_9; 
	private String nazvanie_10; 
	private String opisanie_10; 
	private String nazvanie_11; 
	private String opisanie_11; 
	private String nazvanie_12; 
	private String opisanie_12; 
	private String nazvanie_13; 
	private String opisanie_13; 
	private String nazvanie_14; 
	private String opisanie_14; 
	private String nazvanie_15; 
	private String opisanie_15; 
	private String nazvanie_16; 
	private String opisanie_16; 
	private String nazvanie_17; 
	private String opisanie_17; 
	private String nazvanie_18; 
	private String opisanie_18; 
	private String nazvanie_19; 
	private String opisanie_19; 
	private String nazvanie_20; 
	private String opisanie_20; 
	private String nazvanie_21; 
	private String opisanie_21; 
	private String nazvanie_22; 
	private String opisanie_22; 
	private String nazvanie_23; 
	private String opisanie_23; 
	private String nazvanie_24; 
	private String opisanie_24; 
	private String nazvanie_25; 
	private String opisanie_25; 
	private String nazvanie_26; 
	private String opisanie_26; 
	private String nazvanie_27; 
	private String opisanie_27; 
	private String nazvanie_28; 
	private String opisanie_28; 
	private String nazvanie_29; 
	private String opisanie_29; 
	private String nazvanie_30; 
	private String opisanie_30; 
	private String nazvanie_31; 
	private String opisanie_31; 
	private String nazvanie_32; 
	private String opisanie_32; 
	private String nazvanie_33; 
	private String opisanie_33; 
	private String nazvanie_34; 
	private String opisanie_34; 
	private String nazvanie_35; 
	private String opisanie_35; 
	private String nazvanie_36; 
	private String opisanie_36; 
	private String nazvanie_37; 
	private String opisanie_37; 
	private String nazvanie_38; 
	private String opisanie_38; 
	private String nazvanie_39; 
	private String opisanie_39; 
	private String nazvanie_40; 
	private String opisanie_40; 
	private String nazvanie_41; 
	private String opisanie_41; 
	private String nazvanie_42; 
	private String opisanie_42; 
	private String nazvanie_43; 
	private String opisanie_43; 
	private String nazvanie_44; 
	private String opisanie_44; 
	private String nazvanie_45; 
	private String opisanie_45; 
	private String nazvanie_46; 
	private String opisanie_46; 
	private String nazvanie_47; 
	private String opisanie_47; 
	private String nazvanie_48; 
	private String opisanie_48; 
	private String nazvanie_49; 
	private String opisanie_49; 
	private String nazvanie_50; 
	private String opisanie_50; 
	private String nazvanie_51; 
	private String opisanie_51; 
	private String nazvanie_52; 
	private String opisanie_52; 
	private String nazvanie_53; 
	private String opisanie_53; 
	private String nazvanie_54; 
	private String opisanie_54; 
	private String nazvanie_55; 
	private String opisanie_55; 
	private String nazvanie_56; 
	private String opisanie_56; 
	private String nazvanie_57; 
	private String opisanie_57; 
	private String nazvanie_58; 
	private String opisanie_58; 
	private String nazvanie_59; 
	private String opisanie_59; 
	private String nazvanie_60; 
	private String opisanie_60; 
	private String nazvanie_61; 
	private String opisanie_61; 
	private String nazvanie_62; 
	private String opisanie_62; 
	private String nazvanie_63; 
	private String opisanie_63; 
	private String nazvanie_64; 
	private String opisanie_64; 
	private String nazvanie_65; 
	private String opisanie_65; 
	private String nazvanie_66; 
	private String opisanie_66; 
	private String nazvanie_67; 
	private String opisanie_67; 
	private String region_1; 
	private String region_2; 
	private String region_3; 
	private String admin_zametka1;

	public static String emptyString = new String("");
	private static String slashChar = new String("\\");
	
	public City() {
		
	}
	
	public City(String id, String vkl, String id_gn, String status,
			String samonazvanie, String mfa, String samonazvanie_1,
			String oficialno_1, String flag, String flag_svg, String gerb,
			String gerb_svg, String giddom, String tip, String region_id,
			String strana_id, String ksi1, String ksi2, String ksi_sort,
			String ksi_lat, String telefon, String pochta, String avto,
			String naselenie, String ploshad, String vysota, String osnovan,
			String upominanie, String kontinent, String shirota,
			String dolgota, String shirota_gradus, String shirota_minuta,
			String shirota_sekunda, String dolgota_gradus,
			String dolgota_minuta, String dolgota_sekunda, String sozdan,
			String izmenen, String vrem_pojas, String dop_nazvanie,
			String gn_tip_np, String nazvanie_1, String opisanie_1,
			String nazvanie_2, String opisanie_2, String nazvanie_3,
			String opisanie_3, String nazvanie_4, String opisanie_4,
			String nazvanie_5, String opisanie_5, String nazvanie_6,
			String opisanie_6, String nazvanie_7, String opisanie_7,
			String nazvanie_8, String opisanie_8, String nazvanie_9,
			String opisanie_9, String nazvanie_10, String opisanie_10,
			String nazvanie_11, String opisanie_11, String nazvanie_12,
			String opisanie_12, String nazvanie_13, String opisanie_13,
			String nazvanie_14, String opisanie_14, String nazvanie_15,
			String opisanie_15, String nazvanie_16, String opisanie_16,
			String nazvanie_17, String opisanie_17, String nazvanie_18,
			String opisanie_18, String nazvanie_19, String opisanie_19,
			String nazvanie_20, String opisanie_20, String nazvanie_21,
			String opisanie_21, String nazvanie_22, String opisanie_22,
			String nazvanie_23, String opisanie_23, String nazvanie_24,
			String opisanie_24, String nazvanie_25, String opisanie_25,
			String nazvanie_26, String opisanie_26, String nazvanie_27,
			String opisanie_27, String nazvanie_28, String opisanie_28,
			String nazvanie_29, String opisanie_29, String nazvanie_30,
			String opisanie_30, String nazvanie_31, String opisanie_31,
			String nazvanie_32, String opisanie_32, String nazvanie_33,
			String opisanie_33, String nazvanie_34, String opisanie_34,
			String nazvanie_35, String opisanie_35, String nazvanie_36,
			String opisanie_36, String nazvanie_37, String opisanie_37,
			String nazvanie_38, String opisanie_38, String nazvanie_39,
			String opisanie_39, String nazvanie_40, String opisanie_40,
			String nazvanie_41, String opisanie_41, String nazvanie_42,
			String opisanie_42, String nazvanie_43, String opisanie_43,
			String nazvanie_44, String opisanie_44, String nazvanie_45,
			String opisanie_45, String nazvanie_46, String opisanie_46,
			String nazvanie_47, String opisanie_47, String nazvanie_48,
			String opisanie_48, String nazvanie_49, String opisanie_49,
			String nazvanie_50, String opisanie_50, String nazvanie_51,
			String opisanie_51, String nazvanie_52, String opisanie_52,
			String nazvanie_53, String opisanie_53, String nazvanie_54,
			String opisanie_54, String nazvanie_55, String opisanie_55,
			String nazvanie_56, String opisanie_56, String nazvanie_57,
			String opisanie_57, String nazvanie_58, String opisanie_58,
			String nazvanie_59, String opisanie_59, String nazvanie_60,
			String opisanie_60, String nazvanie_61, String opisanie_61,
			String nazvanie_62, String opisanie_62, String nazvanie_63,
			String opisanie_63, String nazvanie_64, String opisanie_64,
			String nazvanie_65, String opisanie_65, String nazvanie_66,
			String opisanie_66, String nazvanie_67, String opisanie_67,
			String region_1, String region_2, String region_3,
			String admin_zametka1) {
		super();
		this.id = id;
		this.vkl = vkl;
		this.id_gn = id_gn;
		this.status = status;
		this.samonazvanie = samonazvanie;
		this.mfa = mfa;
		this.samonazvanie_1 = samonazvanie_1;
		this.oficialno_1 = oficialno_1;
		this.flag = flag;
		this.flag_svg = flag_svg;
		this.gerb = gerb;
		this.gerb_svg = gerb_svg;
		this.giddom = giddom;
		this.tip = tip;
		this.region_id = region_id;
		this.strana_id = strana_id;
		this.ksi1 = ksi1;
		this.ksi2 = ksi2;
		this.ksi_sort = ksi_sort;
		this.ksi_lat = ksi_lat;
		this.telefon = telefon;
		this.pochta = pochta;
		this.avto = avto;
		this.naselenie = naselenie;
		this.ploshad = ploshad;
		this.vysota = vysota;
		this.osnovan = osnovan;
		this.upominanie = upominanie;
		this.kontinent = kontinent;
		this.shirota = shirota;
		this.dolgota = dolgota;
		this.shirota_gradus = shirota_gradus;
		this.shirota_minuta = shirota_minuta;
		this.shirota_sekunda = shirota_sekunda;
		this.dolgota_gradus = dolgota_gradus;
		this.dolgota_minuta = dolgota_minuta;
		this.dolgota_sekunda = dolgota_sekunda;
		this.sozdan = sozdan;
		this.izmenen = izmenen;
		this.vrem_pojas = vrem_pojas;
		this.dop_nazvanie = dop_nazvanie;
		this.gn_tip_np = gn_tip_np;
		this.nazvanie_1 = nazvanie_1;
		this.opisanie_1 = opisanie_1;
		this.nazvanie_2 = nazvanie_2;
		this.opisanie_2 = opisanie_2;
		this.nazvanie_3 = nazvanie_3;
		this.opisanie_3 = opisanie_3;
		this.nazvanie_4 = nazvanie_4;
		this.opisanie_4 = opisanie_4;
		this.nazvanie_5 = nazvanie_5;
		this.opisanie_5 = opisanie_5;
		this.nazvanie_6 = nazvanie_6;
		this.opisanie_6 = opisanie_6;
		this.nazvanie_7 = nazvanie_7;
		this.opisanie_7 = opisanie_7;
		this.nazvanie_8 = nazvanie_8;
		this.opisanie_8 = opisanie_8;
		this.nazvanie_9 = nazvanie_9;
		this.opisanie_9 = opisanie_9;
		this.nazvanie_10 = nazvanie_10;
		this.opisanie_10 = opisanie_10;
		this.nazvanie_11 = nazvanie_11;
		this.opisanie_11 = opisanie_11;
		this.nazvanie_12 = nazvanie_12;
		this.opisanie_12 = opisanie_12;
		this.nazvanie_13 = nazvanie_13;
		this.opisanie_13 = opisanie_13;
		this.nazvanie_14 = nazvanie_14;
		this.opisanie_14 = opisanie_14;
		this.nazvanie_15 = nazvanie_15;
		this.opisanie_15 = opisanie_15;
		this.nazvanie_16 = nazvanie_16;
		this.opisanie_16 = opisanie_16;
		this.nazvanie_17 = nazvanie_17;
		this.opisanie_17 = opisanie_17;
		this.nazvanie_18 = nazvanie_18;
		this.opisanie_18 = opisanie_18;
		this.nazvanie_19 = nazvanie_19;
		this.opisanie_19 = opisanie_19;
		this.nazvanie_20 = nazvanie_20;
		this.opisanie_20 = opisanie_20;
		this.nazvanie_21 = nazvanie_21;
		this.opisanie_21 = opisanie_21;
		this.nazvanie_22 = nazvanie_22;
		this.opisanie_22 = opisanie_22;
		this.nazvanie_23 = nazvanie_23;
		this.opisanie_23 = opisanie_23;
		this.nazvanie_24 = nazvanie_24;
		this.opisanie_24 = opisanie_24;
		this.nazvanie_25 = nazvanie_25;
		this.opisanie_25 = opisanie_25;
		this.nazvanie_26 = nazvanie_26;
		this.opisanie_26 = opisanie_26;
		this.nazvanie_27 = nazvanie_27;
		this.opisanie_27 = opisanie_27;
		this.nazvanie_28 = nazvanie_28;
		this.opisanie_28 = opisanie_28;
		this.nazvanie_29 = nazvanie_29;
		this.opisanie_29 = opisanie_29;
		this.nazvanie_30 = nazvanie_30;
		this.opisanie_30 = opisanie_30;
		this.nazvanie_31 = nazvanie_31;
		this.opisanie_31 = opisanie_31;
		this.nazvanie_32 = nazvanie_32;
		this.opisanie_32 = opisanie_32;
		this.nazvanie_33 = nazvanie_33;
		this.opisanie_33 = opisanie_33;
		this.nazvanie_34 = nazvanie_34;
		this.opisanie_34 = opisanie_34;
		this.nazvanie_35 = nazvanie_35;
		this.opisanie_35 = opisanie_35;
		this.nazvanie_36 = nazvanie_36;
		this.opisanie_36 = opisanie_36;
		this.nazvanie_37 = nazvanie_37;
		this.opisanie_37 = opisanie_37;
		this.nazvanie_38 = nazvanie_38;
		this.opisanie_38 = opisanie_38;
		this.nazvanie_39 = nazvanie_39;
		this.opisanie_39 = opisanie_39;
		this.nazvanie_40 = nazvanie_40;
		this.opisanie_40 = opisanie_40;
		this.nazvanie_41 = nazvanie_41;
		this.opisanie_41 = opisanie_41;
		this.nazvanie_42 = nazvanie_42;
		this.opisanie_42 = opisanie_42;
		this.nazvanie_43 = nazvanie_43;
		this.opisanie_43 = opisanie_43;
		this.nazvanie_44 = nazvanie_44;
		this.opisanie_44 = opisanie_44;
		this.nazvanie_45 = nazvanie_45;
		this.opisanie_45 = opisanie_45;
		this.nazvanie_46 = nazvanie_46;
		this.opisanie_46 = opisanie_46;
		this.nazvanie_47 = nazvanie_47;
		this.opisanie_47 = opisanie_47;
		this.nazvanie_48 = nazvanie_48;
		this.opisanie_48 = opisanie_48;
		this.nazvanie_49 = nazvanie_49;
		this.opisanie_49 = opisanie_49;
		this.nazvanie_50 = nazvanie_50;
		this.opisanie_50 = opisanie_50;
		this.nazvanie_51 = nazvanie_51;
		this.opisanie_51 = opisanie_51;
		this.nazvanie_52 = nazvanie_52;
		this.opisanie_52 = opisanie_52;
		this.nazvanie_53 = nazvanie_53;
		this.opisanie_53 = opisanie_53;
		this.nazvanie_54 = nazvanie_54;
		this.opisanie_54 = opisanie_54;
		this.nazvanie_55 = nazvanie_55;
		this.opisanie_55 = opisanie_55;
		this.nazvanie_56 = nazvanie_56;
		this.opisanie_56 = opisanie_56;
		this.nazvanie_57 = nazvanie_57;
		this.opisanie_57 = opisanie_57;
		this.nazvanie_58 = nazvanie_58;
		this.opisanie_58 = opisanie_58;
		this.nazvanie_59 = nazvanie_59;
		this.opisanie_59 = opisanie_59;
		this.nazvanie_60 = nazvanie_60;
		this.opisanie_60 = opisanie_60;
		this.nazvanie_61 = nazvanie_61;
		this.opisanie_61 = opisanie_61;
		this.nazvanie_62 = nazvanie_62;
		this.opisanie_62 = opisanie_62;
		this.nazvanie_63 = nazvanie_63;
		this.opisanie_63 = opisanie_63;
		this.nazvanie_64 = nazvanie_64;
		this.opisanie_64 = opisanie_64;
		this.nazvanie_65 = nazvanie_65;
		this.opisanie_65 = opisanie_65;
		this.nazvanie_66 = nazvanie_66;
		this.opisanie_66 = opisanie_66;
		this.nazvanie_67 = nazvanie_67;
		this.opisanie_67 = opisanie_67;
		this.region_1 = region_1;
		this.region_2 = region_2;
		this.region_3 = region_3;
		this.admin_zametka1 = admin_zametka1;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getVkl() {
		return vkl;
	}

	public void setVkl(String vkl) {
		this.vkl = vkl;
	}

	public String getId_gn() {
		return id_gn;
	}

	public void setId_gn(String id_gn) {
		this.id_gn = id_gn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSamonazvanie() {
		return samonazvanie;
	}

	public void setSamonazvanie(String samonazvanie) {
		this.samonazvanie = samonazvanie.replace(slashChar, "");
	}

	public String getMfa() {
		return mfa;
	}

	public void setMfa(String mfa) {
		this.mfa = mfa;
	}

	public String getSamonazvanie_1() {
		return samonazvanie_1;
	}

	public void setSamonazvanie_1(String samonazvanie_1) {
		this.samonazvanie_1 = samonazvanie_1;
	}

	public String getOficialno_1() {
		return oficialno_1;
	}

	public void setOficialno_1(String oficialno_1) {
		this.oficialno_1 = oficialno_1;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getFlag_svg() {
		return flag_svg;
	}

	public void setFlag_svg(String flag_svg) {
		this.flag_svg = flag_svg;
	}

	public String getGerb() {
		return gerb;
	}

	public void setGerb(String gerb) {
		this.gerb = gerb;
	}

	public String getGerb_svg() {
		return gerb_svg;
	}

	public void setGerb_svg(String gerb_svg) {
		this.gerb_svg = gerb_svg;
	}

	public String getGiddom() {
		return giddom;
	}

	public void setGiddom(String giddom) {
		this.giddom = giddom;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getRegion_id() {
		return region_id;
	}

	public void setRegion_id(String region_id) {
		this.region_id = region_id;
	}

	public String getStrana_id() {
		return strana_id;
	}

	public void setStrana_id(String strana_id) {
		this.strana_id = strana_id;
	}

	public String getKsi1() {
		return ksi1;
	}

	public void setKsi1(String ksi1) {
		this.ksi1 = ksi1;
	}

	public String getKsi2() {
		return ksi2;
	}

	public void setKsi2(String ksi2) {
		this.ksi2 = ksi2;
	}

	public String getKsi_sort() {
		return ksi_sort;
	}

	public void setKsi_sort(String ksi_sort) {
		this.ksi_sort = ksi_sort;
	}

	public String getKsi_lat() {
		return ksi_lat;
	}

	public void setKsi_lat(String ksi_lat) {
		this.ksi_lat = ksi_lat;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getPochta() {
		return pochta;
	}

	public void setPochta(String pochta) {
		this.pochta = pochta;
	}

	public String getAvto() {
		return avto;
	}

	public void setAvto(String avto) {
		this.avto = avto;
	}

	public String getNaselenie() {
		return naselenie;
	}

	public void setNaselenie(String naselenie) {
		this.naselenie = naselenie;
	}

	public String getPloshad() {
		return ploshad;
	}

	public void setPloshad(String ploshad) {
		this.ploshad = ploshad;
	}

	public String getVysota() {
		return vysota;
	}

	public void setVysota(String vysota) {
		this.vysota = vysota;
	}

	public String getOsnovan() {
		return osnovan;
	}

	public void setOsnovan(String osnovan) {
		this.osnovan = osnovan;
	}

	public String getUpominanie() {
		return upominanie;
	}

	public void setUpominanie(String upominanie) {
		this.upominanie = upominanie;
	}

	public String getKontinent() {
		return kontinent;
	}

	public void setKontinent(String kontinent) {
		this.kontinent = kontinent;
	}

	public String getShirota() {
		return shirota;
	}

	public void setShirota(String shirota) {
		if ((shirota == null) || (shirota.equals(emptyString))) {
			
		} else {
			this.shirota = shirota;
		}
	}

	public String getDolgota() {
		return dolgota;
	}

	public void setDolgota(String dolgota) {
		if ((dolgota == null) || (dolgota.equals(emptyString))) {
			
		} else {
			this.dolgota = dolgota;
		}
	}

	public String getShirota_gradus() {
		return shirota_gradus;
	}

	public void setShirota_gradus(String shirota_gradus) {
		this.shirota_gradus = shirota_gradus;
	}

	public String getShirota_minuta() {
		return shirota_minuta;
	}

	public void setShirota_minuta(String shirota_minuta) {
		this.shirota_minuta = shirota_minuta;
	}

	public String getShirota_sekunda() {
		return shirota_sekunda;
	}

	public void setShirota_sekunda(String shirota_sekunda) {
		this.shirota_sekunda = shirota_sekunda;
	}

	public String getDolgota_gradus() {
		return dolgota_gradus;
	}

	public void setDolgota_gradus(String dolgota_gradus) {
		this.dolgota_gradus = dolgota_gradus;
	}

	public String getDolgota_minuta() {
		return dolgota_minuta;
	}

	public void setDolgota_minuta(String dolgota_minuta) {
		this.dolgota_minuta = dolgota_minuta;
	}

	public String getDolgota_sekunda() {
		return dolgota_sekunda;
	}

	public void setDolgota_sekunda(String dolgota_sekunda) {
		this.dolgota_sekunda = dolgota_sekunda;
	}

	public String getSozdan() {
		return sozdan;
	}

	public void setSozdan(String sozdan) {
		this.sozdan = sozdan;
	}

	public String getIzmenen() {
		return izmenen;
	}

	public void setIzmenen(String izmenen) {
		this.izmenen = izmenen;
	}

	public String getVrem_pojas() {
		return vrem_pojas;
	}

	public void setVrem_pojas(String vrem_pojas) {
		this.vrem_pojas = vrem_pojas;
	}

	public String getDop_nazvanie() {
		return dop_nazvanie;
	}

	public void setDop_nazvanie(String dop_nazvanie) {
		this.dop_nazvanie = dop_nazvanie;
	}

	public String getGn_tip_np() {
		return gn_tip_np;
	}

	public void setGn_tip_np(String gn_tip_np) {
		this.gn_tip_np = gn_tip_np;
	}

	public String getNazvanie_1() {
		return nazvanie_1;
	}

	public void setNazvanie_1(String nazvanie_1) {
		this.nazvanie_1 = nazvanie_1;
	}

	public String getOpisanie_1() {
		return opisanie_1;
	}

	public void setOpisanie_1(String opisanie_1) {
		this.opisanie_1 = opisanie_1;
	}

	public String getNazvanie_2() {
		return nazvanie_2;
	}

	public void setNazvanie_2(String nazvanie_2) {
		this.nazvanie_2 = nazvanie_2.replace(slashChar, "");;
	}

	@Override
	public String toString() {
		return "CountryBean [id=" + id + ", vkl=" + vkl + ", id_gn=" + id_gn
				+ ", status=" + status + ", samonazvanie=" + samonazvanie
				+ ", mfa=" + mfa + ", samonazvanie_1=" + samonazvanie_1
				+ ", oficialno_1=" + oficialno_1 + ", flag=" + flag
				+ ", flag_svg=" + flag_svg + ", gerb=" + gerb + ", gerb_svg="
				+ gerb_svg + ", giddom=" + giddom + ", tip=" + tip
				+ ", region_id=" + region_id + ", strana_id=" + strana_id
				+ ", ksi1=" + ksi1 + ", ksi2=" + ksi2 + ", ksi_sort="
				+ ksi_sort + ", ksi_lat=" + ksi_lat + ", telefon=" + telefon
				+ ", pochta=" + pochta + ", avto=" + avto + ", naselenie="
				+ naselenie + ", ploshad=" + ploshad + ", vysota=" + vysota
				+ ", osnovan=" + osnovan + ", upominanie=" + upominanie
				+ ", kontinent=" + kontinent + ", shirota=" + shirota
				+ ", dolgota=" + dolgota + ", shirota_gradus=" + shirota_gradus
				+ ", shirota_minuta=" + shirota_minuta + ", shirota_sekunda="
				+ shirota_sekunda + ", dolgota_gradus=" + dolgota_gradus
				+ ", dolgota_minuta=" + dolgota_minuta + ", dolgota_sekunda="
				+ dolgota_sekunda + ", sozdan=" + sozdan + ", izmenen="
				+ izmenen + ", vrem_pojas=" + vrem_pojas + ", dop_nazvanie="
				+ dop_nazvanie + ", gn_tip_np=" + gn_tip_np + ", nazvanie_1="
				+ nazvanie_1 + ", opisanie_1=" + opisanie_1 + ", nazvanie_2="
				+ nazvanie_2 + ", opisanie_2=" + opisanie_2 + ", nazvanie_3="
				+ nazvanie_3 + ", opisanie_3=" + opisanie_3 + ", nazvanie_4="
				+ nazvanie_4 + ", opisanie_4=" + opisanie_4 + ", nazvanie_5="
				+ nazvanie_5 + ", opisanie_5=" + opisanie_5 + ", nazvanie_6="
				+ nazvanie_6 + ", opisanie_6=" + opisanie_6 + ", nazvanie_7="
				+ nazvanie_7 + ", opisanie_7=" + opisanie_7 + ", nazvanie_8="
				+ nazvanie_8 + ", opisanie_8=" + opisanie_8 + ", nazvanie_9="
				+ nazvanie_9 + ", opisanie_9=" + opisanie_9 + ", nazvanie_10="
				+ nazvanie_10 + ", opisanie_10=" + opisanie_10
				+ ", nazvanie_11=" + nazvanie_11 + ", opisanie_11="
				+ opisanie_11 + ", nazvanie_12=" + nazvanie_12
				+ ", opisanie_12=" + opisanie_12 + ", nazvanie_13="
				+ nazvanie_13 + ", opisanie_13=" + opisanie_13
				+ ", nazvanie_14=" + nazvanie_14 + ", opisanie_14="
				+ opisanie_14 + ", nazvanie_15=" + nazvanie_15
				+ ", opisanie_15=" + opisanie_15 + ", nazvanie_16="
				+ nazvanie_16 + ", opisanie_16=" + opisanie_16
				+ ", nazvanie_17=" + nazvanie_17 + ", opisanie_17="
				+ opisanie_17 + ", nazvanie_18=" + nazvanie_18
				+ ", opisanie_18=" + opisanie_18 + ", nazvanie_19="
				+ nazvanie_19 + ", opisanie_19=" + opisanie_19
				+ ", nazvanie_20=" + nazvanie_20 + ", opisanie_20="
				+ opisanie_20 + ", nazvanie_21=" + nazvanie_21
				+ ", opisanie_21=" + opisanie_21 + ", nazvanie_22="
				+ nazvanie_22 + ", opisanie_22=" + opisanie_22
				+ ", nazvanie_23=" + nazvanie_23 + ", opisanie_23="
				+ opisanie_23 + ", nazvanie_24=" + nazvanie_24
				+ ", opisanie_24=" + opisanie_24 + ", nazvanie_25="
				+ nazvanie_25 + ", opisanie_25=" + opisanie_25
				+ ", nazvanie_26=" + nazvanie_26 + ", opisanie_26="
				+ opisanie_26 + ", nazvanie_27=" + nazvanie_27
				+ ", opisanie_27=" + opisanie_27 + ", nazvanie_28="
				+ nazvanie_28 + ", opisanie_28=" + opisanie_28
				+ ", nazvanie_29=" + nazvanie_29 + ", opisanie_29="
				+ opisanie_29 + ", nazvanie_30=" + nazvanie_30
				+ ", opisanie_30=" + opisanie_30 + ", nazvanie_31="
				+ nazvanie_31 + ", opisanie_31=" + opisanie_31
				+ ", nazvanie_32=" + nazvanie_32 + ", opisanie_32="
				+ opisanie_32 + ", nazvanie_33=" + nazvanie_33
				+ ", opisanie_33=" + opisanie_33 + ", nazvanie_34="
				+ nazvanie_34 + ", opisanie_34=" + opisanie_34
				+ ", nazvanie_35=" + nazvanie_35 + ", opisanie_35="
				+ opisanie_35 + ", nazvanie_36=" + nazvanie_36
				+ ", opisanie_36=" + opisanie_36 + ", nazvanie_37="
				+ nazvanie_37 + ", opisanie_37=" + opisanie_37
				+ ", nazvanie_38=" + nazvanie_38 + ", opisanie_38="
				+ opisanie_38 + ", nazvanie_39=" + nazvanie_39
				+ ", opisanie_39=" + opisanie_39 + ", nazvanie_40="
				+ nazvanie_40 + ", opisanie_40=" + opisanie_40
				+ ", nazvanie_41=" + nazvanie_41 + ", opisanie_41="
				+ opisanie_41 + ", nazvanie_42=" + nazvanie_42
				+ ", opisanie_42=" + opisanie_42 + ", nazvanie_43="
				+ nazvanie_43 + ", opisanie_43=" + opisanie_43
				+ ", nazvanie_44=" + nazvanie_44 + ", opisanie_44="
				+ opisanie_44 + ", nazvanie_45=" + nazvanie_45
				+ ", opisanie_45=" + opisanie_45 + ", nazvanie_46="
				+ nazvanie_46 + ", opisanie_46=" + opisanie_46
				+ ", nazvanie_47=" + nazvanie_47 + ", opisanie_47="
				+ opisanie_47 + ", nazvanie_48=" + nazvanie_48
				+ ", opisanie_48=" + opisanie_48 + ", nazvanie_49="
				+ nazvanie_49 + ", opisanie_49=" + opisanie_49
				+ ", nazvanie_50=" + nazvanie_50 + ", opisanie_50="
				+ opisanie_50 + ", nazvanie_51=" + nazvanie_51
				+ ", opisanie_51=" + opisanie_51 + ", nazvanie_52="
				+ nazvanie_52 + ", opisanie_52=" + opisanie_52
				+ ", nazvanie_53=" + nazvanie_53 + ", opisanie_53="
				+ opisanie_53 + ", nazvanie_54=" + nazvanie_54
				+ ", opisanie_54=" + opisanie_54 + ", nazvanie_55="
				+ nazvanie_55 + ", opisanie_55=" + opisanie_55
				+ ", nazvanie_56=" + nazvanie_56 + ", opisanie_56="
				+ opisanie_56 + ", nazvanie_57=" + nazvanie_57
				+ ", opisanie_57=" + opisanie_57 + ", nazvanie_58="
				+ nazvanie_58 + ", opisanie_58=" + opisanie_58
				+ ", nazvanie_59=" + nazvanie_59 + ", opisanie_59="
				+ opisanie_59 + ", nazvanie_60=" + nazvanie_60
				+ ", opisanie_60=" + opisanie_60 + ", nazvanie_61="
				+ nazvanie_61 + ", opisanie_61=" + opisanie_61
				+ ", nazvanie_62=" + nazvanie_62 + ", opisanie_62="
				+ opisanie_62 + ", nazvanie_63=" + nazvanie_63
				+ ", opisanie_63=" + opisanie_63 + ", nazvanie_64="
				+ nazvanie_64 + ", opisanie_64=" + opisanie_64
				+ ", nazvanie_65=" + nazvanie_65 + ", opisanie_65="
				+ opisanie_65 + ", nazvanie_66=" + nazvanie_66
				+ ", opisanie_66=" + opisanie_66 + ", nazvanie_67="
				+ nazvanie_67 + ", opisanie_67=" + opisanie_67 + ", region_1="
				+ region_1 + ", region_2=" + region_2 + ", region_3="
				+ region_3 + ", admin_zametka1=" + admin_zametka1 + "]";
	}

	public String getOpisanie_2() {
		return opisanie_2;
	}

	public void setOpisanie_2(String opisanie_2) {
		this.opisanie_2 = opisanie_2;
	}

	public String getNazvanie_3() {
		return nazvanie_3;
	}

	public void setNazvanie_3(String nazvanie_3) {
		this.nazvanie_3 = nazvanie_3;
	}

	public String getOpisanie_3() {
		return opisanie_3;
	}

	public void setOpisanie_3(String opisanie_3) {
		this.opisanie_3 = opisanie_3;
	}

	public String getNazvanie_4() {
		return nazvanie_4;
	}

	public void setNazvanie_4(String nazvanie_4) {
		this.nazvanie_4 = nazvanie_4;
	}

	public String getOpisanie_4() {
		return opisanie_4;
	}

	public void setOpisanie_4(String opisanie_4) {
		this.opisanie_4 = opisanie_4;
	}

	public String getNazvanie_5() {
		return nazvanie_5;
	}

	public void setNazvanie_5(String nazvanie_5) {
		this.nazvanie_5 = nazvanie_5;
	}

	public String getOpisanie_5() {
		return opisanie_5;
	}

	public void setOpisanie_5(String opisanie_5) {
		this.opisanie_5 = opisanie_5;
	}

	public String getNazvanie_6() {
		return nazvanie_6;
	}

	public void setNazvanie_6(String nazvanie_6) {
		this.nazvanie_6 = nazvanie_6;
	}

	public String getOpisanie_6() {
		return opisanie_6;
	}

	public void setOpisanie_6(String opisanie_6) {
		this.opisanie_6 = opisanie_6;
	}

	public String getNazvanie_7() {
		return nazvanie_7;
	}

	public void setNazvanie_7(String nazvanie_7) {
		this.nazvanie_7 = nazvanie_7;
	}

	public String getOpisanie_7() {
		return opisanie_7;
	}

	public void setOpisanie_7(String opisanie_7) {
		this.opisanie_7 = opisanie_7;
	}

	public String getNazvanie_8() {
		return nazvanie_8;
	}

	public void setNazvanie_8(String nazvanie_8) {
		this.nazvanie_8 = nazvanie_8;
	}

	public String getOpisanie_8() {
		return opisanie_8;
	}

	public void setOpisanie_8(String opisanie_8) {
		this.opisanie_8 = opisanie_8;
	}

	public String getNazvanie_9() {
		return nazvanie_9;
	}

	public void setNazvanie_9(String nazvanie_9) {
		this.nazvanie_9 = nazvanie_9;
	}

	public String getOpisanie_9() {
		return opisanie_9;
	}

	public void setOpisanie_9(String opisanie_9) {
		this.opisanie_9 = opisanie_9;
	}

	public String getNazvanie_10() {
		return nazvanie_10;
	}

	public void setNazvanie_10(String nazvanie_10) {
		this.nazvanie_10 = nazvanie_10;
	}

	public String getOpisanie_10() {
		return opisanie_10;
	}

	public void setOpisanie_10(String opisanie_10) {
		this.opisanie_10 = opisanie_10;
	}

	public String getNazvanie_11() {
		return nazvanie_11;
	}

	public void setNazvanie_11(String nazvanie_11) {
		this.nazvanie_11 = nazvanie_11;
	}

	public String getOpisanie_11() {
		return opisanie_11;
	}

	public void setOpisanie_11(String opisanie_11) {
		this.opisanie_11 = opisanie_11;
	}

	public String getNazvanie_12() {
		return nazvanie_12;
	}

	public void setNazvanie_12(String nazvanie_12) {
		this.nazvanie_12 = nazvanie_12;
	}

	public String getOpisanie_12() {
		return opisanie_12;
	}

	public void setOpisanie_12(String opisanie_12) {
		this.opisanie_12 = opisanie_12;
	}

	public String getNazvanie_13() {
		return nazvanie_13;
	}

	public void setNazvanie_13(String nazvanie_13) {
		this.nazvanie_13 = nazvanie_13;
	}

	public String getOpisanie_13() {
		return opisanie_13;
	}

	public void setOpisanie_13(String opisanie_13) {
		this.opisanie_13 = opisanie_13;
	}

	public String getNazvanie_14() {
		return nazvanie_14;
	}

	public void setNazvanie_14(String nazvanie_14) {
		this.nazvanie_14 = nazvanie_14;
	}

	public String getOpisanie_14() {
		return opisanie_14;
	}

	public void setOpisanie_14(String opisanie_14) {
		this.opisanie_14 = opisanie_14;
	}

	public String getNazvanie_15() {
		return nazvanie_15;
	}

	public void setNazvanie_15(String nazvanie_15) {
		this.nazvanie_15 = nazvanie_15;
	}

	public String getOpisanie_15() {
		return opisanie_15;
	}

	public void setOpisanie_15(String opisanie_15) {
		this.opisanie_15 = opisanie_15;
	}

	public String getNazvanie_16() {
		return nazvanie_16;
	}

	public void setNazvanie_16(String nazvanie_16) {
		this.nazvanie_16 = nazvanie_16;
	}

	public String getOpisanie_16() {
		return opisanie_16;
	}

	public void setOpisanie_16(String opisanie_16) {
		this.opisanie_16 = opisanie_16;
	}

	public String getNazvanie_17() {
		return nazvanie_17;
	}

	public void setNazvanie_17(String nazvanie_17) {
		this.nazvanie_17 = nazvanie_17;
	}

	public String getOpisanie_17() {
		return opisanie_17;
	}

	public void setOpisanie_17(String opisanie_17) {
		this.opisanie_17 = opisanie_17;
	}

	public String getNazvanie_18() {
		return nazvanie_18;
	}

	public void setNazvanie_18(String nazvanie_18) {
		this.nazvanie_18 = nazvanie_18;
	}

	public String getOpisanie_18() {
		return opisanie_18;
	}

	public void setOpisanie_18(String opisanie_18) {
		this.opisanie_18 = opisanie_18;
	}

	public String getNazvanie_19() {
		return nazvanie_19;
	}

	public void setNazvanie_19(String nazvanie_19) {
		this.nazvanie_19 = nazvanie_19;
	}

	public String getOpisanie_19() {
		return opisanie_19;
	}

	public void setOpisanie_19(String opisanie_19) {
		this.opisanie_19 = opisanie_19;
	}

	public String getNazvanie_20() {
		return nazvanie_20;
	}

	public void setNazvanie_20(String nazvanie_20) {
		this.nazvanie_20 = nazvanie_20;
	}

	public String getOpisanie_20() {
		return opisanie_20;
	}

	public void setOpisanie_20(String opisanie_20) {
		this.opisanie_20 = opisanie_20;
	}

	public String getNazvanie_21() {
		return nazvanie_21;
	}

	public void setNazvanie_21(String nazvanie_21) {
		this.nazvanie_21 = nazvanie_21;
	}

	public String getOpisanie_21() {
		return opisanie_21;
	}

	public void setOpisanie_21(String opisanie_21) {
		this.opisanie_21 = opisanie_21;
	}

	public String getNazvanie_22() {
		return nazvanie_22;
	}

	public void setNazvanie_22(String nazvanie_22) {
		this.nazvanie_22 = nazvanie_22;
	}

	public String getOpisanie_22() {
		return opisanie_22;
	}

	public void setOpisanie_22(String opisanie_22) {
		this.opisanie_22 = opisanie_22;
	}

	public String getNazvanie_23() {
		return nazvanie_23;
	}

	public void setNazvanie_23(String nazvanie_23) {
		this.nazvanie_23 = nazvanie_23;
	}

	public String getOpisanie_23() {
		return opisanie_23;
	}

	public void setOpisanie_23(String opisanie_23) {
		this.opisanie_23 = opisanie_23;
	}

	public String getNazvanie_24() {
		return nazvanie_24;
	}

	public void setNazvanie_24(String nazvanie_24) {
		this.nazvanie_24 = nazvanie_24;
	}

	public String getOpisanie_24() {
		return opisanie_24;
	}

	public void setOpisanie_24(String opisanie_24) {
		this.opisanie_24 = opisanie_24;
	}

	public String getNazvanie_25() {
		return nazvanie_25;
	}

	public void setNazvanie_25(String nazvanie_25) {
		this.nazvanie_25 = nazvanie_25;
	}

	public String getOpisanie_25() {
		return opisanie_25;
	}

	public void setOpisanie_25(String opisanie_25) {
		this.opisanie_25 = opisanie_25;
	}

	public String getNazvanie_26() {
		return nazvanie_26;
	}

	public void setNazvanie_26(String nazvanie_26) {
		this.nazvanie_26 = nazvanie_26;
	}

	public String getOpisanie_26() {
		return opisanie_26;
	}

	public void setOpisanie_26(String opisanie_26) {
		this.opisanie_26 = opisanie_26;
	}

	public String getNazvanie_27() {
		return nazvanie_27;
	}

	public void setNazvanie_27(String nazvanie_27) {
		this.nazvanie_27 = nazvanie_27;
	}

	public String getOpisanie_27() {
		return opisanie_27;
	}

	public void setOpisanie_27(String opisanie_27) {
		this.opisanie_27 = opisanie_27;
	}

	public String getNazvanie_28() {
		return nazvanie_28;
	}

	public void setNazvanie_28(String nazvanie_28) {
		this.nazvanie_28 = nazvanie_28;
	}

	public String getOpisanie_28() {
		return opisanie_28;
	}

	public void setOpisanie_28(String opisanie_28) {
		this.opisanie_28 = opisanie_28;
	}

	public String getNazvanie_29() {
		return nazvanie_29;
	}

	public void setNazvanie_29(String nazvanie_29) {
		this.nazvanie_29 = nazvanie_29;
	}

	public String getOpisanie_29() {
		return opisanie_29;
	}

	public void setOpisanie_29(String opisanie_29) {
		this.opisanie_29 = opisanie_29;
	}

	public String getNazvanie_30() {
		return nazvanie_30;
	}

	public void setNazvanie_30(String nazvanie_30) {
		this.nazvanie_30 = nazvanie_30;
	}

	public String getOpisanie_30() {
		return opisanie_30;
	}

	public void setOpisanie_30(String opisanie_30) {
		this.opisanie_30 = opisanie_30;
	}

	public String getNazvanie_31() {
		return nazvanie_31;
	}

	public void setNazvanie_31(String nazvanie_31) {
		this.nazvanie_31 = nazvanie_31;
	}

	public String getOpisanie_31() {
		return opisanie_31;
	}

	public void setOpisanie_31(String opisanie_31) {
		this.opisanie_31 = opisanie_31;
	}

	public String getNazvanie_32() {
		return nazvanie_32;
	}

	public void setNazvanie_32(String nazvanie_32) {
		this.nazvanie_32 = nazvanie_32;
	}

	public String getOpisanie_32() {
		return opisanie_32;
	}

	public void setOpisanie_32(String opisanie_32) {
		this.opisanie_32 = opisanie_32;
	}

	public String getNazvanie_33() {
		return nazvanie_33;
	}

	public void setNazvanie_33(String nazvanie_33) {
		this.nazvanie_33 = nazvanie_33;
	}

	public String getOpisanie_33() {
		return opisanie_33;
	}

	public void setOpisanie_33(String opisanie_33) {
		this.opisanie_33 = opisanie_33;
	}

	public String getNazvanie_34() {
		return nazvanie_34;
	}

	public void setNazvanie_34(String nazvanie_34) {
		this.nazvanie_34 = nazvanie_34;
	}

	public String getOpisanie_34() {
		return opisanie_34;
	}

	public void setOpisanie_34(String opisanie_34) {
		this.opisanie_34 = opisanie_34;
	}

	public String getNazvanie_35() {
		return nazvanie_35;
	}

	public void setNazvanie_35(String nazvanie_35) {
		this.nazvanie_35 = nazvanie_35;
	}

	public String getOpisanie_35() {
		return opisanie_35;
	}

	public void setOpisanie_35(String opisanie_35) {
		this.opisanie_35 = opisanie_35;
	}

	public String getNazvanie_36() {
		return nazvanie_36;
	}

	public void setNazvanie_36(String nazvanie_36) {
		this.nazvanie_36 = nazvanie_36;
	}

	public String getOpisanie_36() {
		return opisanie_36;
	}

	public void setOpisanie_36(String opisanie_36) {
		this.opisanie_36 = opisanie_36;
	}

	public String getNazvanie_37() {
		return nazvanie_37;
	}

	public void setNazvanie_37(String nazvanie_37) {
		this.nazvanie_37 = nazvanie_37;
	}

	public String getOpisanie_37() {
		return opisanie_37;
	}

	public void setOpisanie_37(String opisanie_37) {
		this.opisanie_37 = opisanie_37;
	}

	public String getNazvanie_38() {
		return nazvanie_38;
	}

	public void setNazvanie_38(String nazvanie_38) {
		this.nazvanie_38 = nazvanie_38;
	}

	public String getOpisanie_38() {
		return opisanie_38;
	}

	public void setOpisanie_38(String opisanie_38) {
		this.opisanie_38 = opisanie_38;
	}

	public String getNazvanie_39() {
		return nazvanie_39;
	}

	public void setNazvanie_39(String nazvanie_39) {
		this.nazvanie_39 = nazvanie_39;
	}

	public String getOpisanie_39() {
		return opisanie_39;
	}

	public void setOpisanie_39(String opisanie_39) {
		this.opisanie_39 = opisanie_39;
	}

	public String getNazvanie_40() {
		return nazvanie_40;
	}

	public void setNazvanie_40(String nazvanie_40) {
		this.nazvanie_40 = nazvanie_40;
	}

	public String getOpisanie_40() {
		return opisanie_40;
	}

	public void setOpisanie_40(String opisanie_40) {
		this.opisanie_40 = opisanie_40;
	}

	public String getNazvanie_41() {
		return nazvanie_41;
	}

	public void setNazvanie_41(String nazvanie_41) {
		this.nazvanie_41 = nazvanie_41;
	}

	public String getOpisanie_41() {
		return opisanie_41;
	}

	public void setOpisanie_41(String opisanie_41) {
		this.opisanie_41 = opisanie_41;
	}

	public String getNazvanie_42() {
		return nazvanie_42;
	}

	public void setNazvanie_42(String nazvanie_42) {
		this.nazvanie_42 = nazvanie_42;
	}

	public String getOpisanie_42() {
		return opisanie_42;
	}

	public void setOpisanie_42(String opisanie_42) {
		this.opisanie_42 = opisanie_42;
	}

	public String getNazvanie_43() {
		return nazvanie_43;
	}

	public void setNazvanie_43(String nazvanie_43) {
		this.nazvanie_43 = nazvanie_43;
	}

	public String getOpisanie_43() {
		return opisanie_43;
	}

	public void setOpisanie_43(String opisanie_43) {
		this.opisanie_43 = opisanie_43;
	}

	public String getNazvanie_44() {
		return nazvanie_44;
	}

	public void setNazvanie_44(String nazvanie_44) {
		this.nazvanie_44 = nazvanie_44;
	}

	public String getOpisanie_44() {
		return opisanie_44;
	}

	public void setOpisanie_44(String opisanie_44) {
		this.opisanie_44 = opisanie_44;
	}

	public String getNazvanie_45() {
		return nazvanie_45;
	}

	public void setNazvanie_45(String nazvanie_45) {
		this.nazvanie_45 = nazvanie_45;
	}

	public String getOpisanie_45() {
		return opisanie_45;
	}

	public void setOpisanie_45(String opisanie_45) {
		this.opisanie_45 = opisanie_45;
	}

	public String getNazvanie_46() {
		return nazvanie_46;
	}

	public void setNazvanie_46(String nazvanie_46) {
		this.nazvanie_46 = nazvanie_46;
	}

	public String getOpisanie_46() {
		return opisanie_46;
	}

	public void setOpisanie_46(String opisanie_46) {
		this.opisanie_46 = opisanie_46;
	}

	public String getNazvanie_47() {
		return nazvanie_47;
	}

	public void setNazvanie_47(String nazvanie_47) {
		this.nazvanie_47 = nazvanie_47;
	}

	public String getOpisanie_47() {
		return opisanie_47;
	}

	public void setOpisanie_47(String opisanie_47) {
		this.opisanie_47 = opisanie_47;
	}

	public String getNazvanie_48() {
		return nazvanie_48;
	}

	public void setNazvanie_48(String nazvanie_48) {
		this.nazvanie_48 = nazvanie_48;
	}

	public String getOpisanie_48() {
		return opisanie_48;
	}

	public void setOpisanie_48(String opisanie_48) {
		this.opisanie_48 = opisanie_48;
	}

	public String getNazvanie_49() {
		return nazvanie_49;
	}

	public void setNazvanie_49(String nazvanie_49) {
		this.nazvanie_49 = nazvanie_49;
	}

	public String getOpisanie_49() {
		return opisanie_49;
	}

	public void setOpisanie_49(String opisanie_49) {
		this.opisanie_49 = opisanie_49;
	}

	public String getNazvanie_50() {
		return nazvanie_50;
	}

	public void setNazvanie_50(String nazvanie_50) {
		this.nazvanie_50 = nazvanie_50;
	}

	public String getOpisanie_50() {
		return opisanie_50;
	}

	public void setOpisanie_50(String opisanie_50) {
		this.opisanie_50 = opisanie_50;
	}

	public String getNazvanie_51() {
		return nazvanie_51;
	}

	public void setNazvanie_51(String nazvanie_51) {
		this.nazvanie_51 = nazvanie_51;
	}

	public String getOpisanie_51() {
		return opisanie_51;
	}

	public void setOpisanie_51(String opisanie_51) {
		this.opisanie_51 = opisanie_51;
	}

	public String getNazvanie_52() {
		return nazvanie_52;
	}

	public void setNazvanie_52(String nazvanie_52) {
		this.nazvanie_52 = nazvanie_52;
	}

	public String getOpisanie_52() {
		return opisanie_52;
	}

	public void setOpisanie_52(String opisanie_52) {
		this.opisanie_52 = opisanie_52;
	}

	public String getNazvanie_53() {
		return nazvanie_53;
	}

	public void setNazvanie_53(String nazvanie_53) {
		this.nazvanie_53 = nazvanie_53;
	}

	public String getOpisanie_53() {
		return opisanie_53;
	}

	public void setOpisanie_53(String opisanie_53) {
		this.opisanie_53 = opisanie_53;
	}

	public String getNazvanie_54() {
		return nazvanie_54;
	}

	public void setNazvanie_54(String nazvanie_54) {
		this.nazvanie_54 = nazvanie_54;
	}

	public String getOpisanie_54() {
		return opisanie_54;
	}

	public void setOpisanie_54(String opisanie_54) {
		this.opisanie_54 = opisanie_54;
	}

	public String getNazvanie_55() {
		return nazvanie_55;
	}

	public void setNazvanie_55(String nazvanie_55) {
		this.nazvanie_55 = nazvanie_55;
	}

	public String getOpisanie_55() {
		return opisanie_55;
	}

	public void setOpisanie_55(String opisanie_55) {
		this.opisanie_55 = opisanie_55;
	}

	public String getNazvanie_56() {
		return nazvanie_56;
	}

	public void setNazvanie_56(String nazvanie_56) {
		this.nazvanie_56 = nazvanie_56;
	}

	public String getOpisanie_56() {
		return opisanie_56;
	}

	public void setOpisanie_56(String opisanie_56) {
		this.opisanie_56 = opisanie_56;
	}

	public String getNazvanie_57() {
		return nazvanie_57;
	}

	public void setNazvanie_57(String nazvanie_57) {
		this.nazvanie_57 = nazvanie_57;
	}

	public String getOpisanie_57() {
		return opisanie_57;
	}

	public void setOpisanie_57(String opisanie_57) {
		this.opisanie_57 = opisanie_57;
	}

	public String getNazvanie_58() {
		return nazvanie_58;
	}

	public void setNazvanie_58(String nazvanie_58) {
		this.nazvanie_58 = nazvanie_58;
	}

	public String getOpisanie_58() {
		return opisanie_58;
	}

	public void setOpisanie_58(String opisanie_58) {
		this.opisanie_58 = opisanie_58;
	}

	public String getNazvanie_59() {
		return nazvanie_59;
	}

	public void setNazvanie_59(String nazvanie_59) {
		this.nazvanie_59 = nazvanie_59;
	}

	public String getOpisanie_59() {
		return opisanie_59;
	}

	public void setOpisanie_59(String opisanie_59) {
		this.opisanie_59 = opisanie_59;
	}

	public String getNazvanie_60() {
		return nazvanie_60;
	}

	public void setNazvanie_60(String nazvanie_60) {
		this.nazvanie_60 = nazvanie_60;
	}

	public String getOpisanie_60() {
		return opisanie_60;
	}

	public void setOpisanie_60(String opisanie_60) {
		this.opisanie_60 = opisanie_60;
	}

	public String getNazvanie_61() {
		return nazvanie_61;
	}

	public void setNazvanie_61(String nazvanie_61) {
		this.nazvanie_61 = nazvanie_61;
	}

	public String getOpisanie_61() {
		return opisanie_61;
	}

	public void setOpisanie_61(String opisanie_61) {
		this.opisanie_61 = opisanie_61;
	}

	public String getNazvanie_62() {
		return nazvanie_62;
	}

	public void setNazvanie_62(String nazvanie_62) {
		this.nazvanie_62 = nazvanie_62;
	}

	public String getOpisanie_62() {
		return opisanie_62;
	}

	public void setOpisanie_62(String opisanie_62) {
		this.opisanie_62 = opisanie_62;
	}

	public String getNazvanie_63() {
		return nazvanie_63;
	}

	public void setNazvanie_63(String nazvanie_63) {
		this.nazvanie_63 = nazvanie_63;
	}

	public String getOpisanie_63() {
		return opisanie_63;
	}

	public void setOpisanie_63(String opisanie_63) {
		this.opisanie_63 = opisanie_63;
	}

	public String getNazvanie_64() {
		return nazvanie_64;
	}

	public void setNazvanie_64(String nazvanie_64) {
		this.nazvanie_64 = nazvanie_64;
	}

	public String getOpisanie_64() {
		return opisanie_64;
	}

	public void setOpisanie_64(String opisanie_64) {
		this.opisanie_64 = opisanie_64;
	}

	public String getNazvanie_65() {
		return nazvanie_65;
	}

	public void setNazvanie_65(String nazvanie_65) {
		this.nazvanie_65 = nazvanie_65;
	}

	public String getOpisanie_65() {
		return opisanie_65;
	}

	public void setOpisanie_65(String opisanie_65) {
		this.opisanie_65 = opisanie_65;
	}

	public String getNazvanie_66() {
		return nazvanie_66;
	}

	public void setNazvanie_66(String nazvanie_66) {
		this.nazvanie_66 = nazvanie_66;
	}

	public String getOpisanie_66() {
		return opisanie_66;
	}

	public void setOpisanie_66(String opisanie_66) {
		this.opisanie_66 = opisanie_66;
	}

	public String getNazvanie_67() {
		return nazvanie_67;
	}

	public void setNazvanie_67(String nazvanie_67) {
		this.nazvanie_67 = nazvanie_67;
	}

	public String getOpisanie_67() {
		return opisanie_67;
	}

	public void setOpisanie_67(String opisanie_67) {
		this.opisanie_67 = opisanie_67;
	}

	public String getRegion_1() {
		return region_1;
	}

	public void setRegion_1(String region_1) {
		this.region_1 = region_1;
	}

	public String getRegion_2() {
		return region_2;
	}

	public void setRegion_2(String region_2) {
		this.region_2 = region_2;
	}

	public String getRegion_3() {
		return region_3;
	}

	public void setRegion_3(String region_3) {
		this.region_3 = region_3;
	}

	public String getAdmin_zametka1() {
		return admin_zametka1;
	}

	public void setAdmin_zametka1(String admin_zametka1) {
		this.admin_zametka1 = admin_zametka1;
	}
}
