package Resources;

import java.util.ArrayList;
import java.util.List;

import pojo.BasePojoSerialize;
import pojo.LocationSerialize;

public class TestDataBuild {
	public BasePojoSerialize addPlacePayload( String name, String language, String address) {
		BasePojoSerialize bp= new BasePojoSerialize();
		   List<String> typeList= new ArrayList<String>();
		   typeList.add("Abcd");
		   typeList.add("Efgh");
		   LocationSerialize ls = new LocationSerialize();
		   bp.setAccuracy(50);
		   bp.setAddress(address);
		   bp.setLanguage(language);
		   bp.setName(name);
		   bp.setPhone_number("xxxxxxx");
		   bp.setWebsite("ww.dshf");
		   bp.setTypes(typeList);
		   ls.setLat(-132134);
		   ls.setLng(1234234);
		   bp.setLocation(ls);
		   
		   return bp;
		   
	}

	public String deletePayload(String place_id) {
		return "{\r\n"
				+ "  \"place_id\": \""+place_id+"\"\r\n}"
				;
	}
}
