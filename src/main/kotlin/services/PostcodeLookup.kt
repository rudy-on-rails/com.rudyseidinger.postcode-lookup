package services

import models.Address
import org.json.JSONObject
import java.net.URL

class PostcodeLookup(val postcode: String) {
    fun execute(): Address {
        val address = requestText(buildUrl(postcode))
        return parseToAddress(parseToJson(address))
    }

    private fun parseToAddress(json : JSONObject) : Address{
        return Address(region = json.getString("region"), adminDistrict = json.getString("admin_district"))
    }

    private fun parseToJson(jsonString : String) : JSONObject{
        return JSONObject(jsonString).getJSONObject("result" )
    }

    private fun buildUrl(postcode: String): String{
        return "https://api.postcodes.io/postcodes/".plus(postcode)
    }

    private fun requestText(url: String) : String{
        return URL(url).readText()
    }
}