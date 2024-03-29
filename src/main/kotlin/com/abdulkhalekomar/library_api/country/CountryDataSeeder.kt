package com.abdulkhalekomar.library_api.country

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class CountryDataSeeder(private val countryRepository: ICountryRepository) : CommandLineRunner {
	override fun run(vararg args: String?) {
		val countries = mutableListOf(
			Country(countryName = "AD"),
			Country(countryName = "AE"),
			Country(countryName = "AF"),
			Country(countryName = "AG"),
			Country(countryName = "AI"),
			Country(countryName = "AL"),
			Country(countryName = "AM"),
			Country(countryName = "AO"),
			Country(countryName = "AR"),
			Country(countryName = "AS"),
			Country(countryName = "AT"),
			Country(countryName = "AU"),
			Country(countryName = "AW"),
			Country(countryName = "AX"),
			Country(countryName = "AZ"),
			Country(countryName = "BA"),
			Country(countryName = "BB"),
			Country(countryName = "BD"),
			Country(countryName = "BE"),
			Country(countryName = "BF"),
			Country(countryName = "BG"),
			Country(countryName = "BH"),
			Country(countryName = "BI"),
			Country(countryName = "BJ"),
			Country(countryName = "BL"),
			Country(countryName = "BM"),
			Country(countryName = "BN"),
			Country(countryName = "BO"),
			Country(countryName = "BQ"),
			Country(countryName = "BR"),
			Country(countryName = "BS"),
			Country(countryName = "BT"),
			Country(countryName = "BV"),
			Country(countryName = "BW"),
			Country(countryName = "BY"),
			Country(countryName = "BZ"),
			Country(countryName = "CA"),
			Country(countryName = "CC"),
			Country(countryName = "CE"),
			Country(countryName = "CF"),
			Country(countryName = "CK"),
			Country(countryName = "CL"),
			Country(countryName = "CM"),
			Country(countryName = "CN"),
			Country(countryName = "CO"),
			Country(countryName = "CR"),
			Country(countryName = "CU"),
			Country(countryName = "CW"),
			Country(countryName = "CX"),
			Country(countryName = "CY"),
			Country(countryName = "CZ"),
			Country(countryName = "DE"),
			Country(countryName = "DJ"),
			Country(countryName = "DK"),
			Country(countryName = "DM"),
			Country(countryName = "DO"),
			Country(countryName = "DZ"),
			Country(countryName = "EA"),
			Country(countryName = "EC"),
			Country(countryName = "EE"),
			Country(countryName = "EG"),
			Country(countryName = "EH"),
			Country(countryName = "ER"),
			Country(countryName = "ES"),
			Country(countryName = "ET"),
			Country(countryName = "EU"),
			Country(countryName = "FI"),
			Country(countryName = "FJ"),
			Country(countryName = "FK"),
			Country(countryName = "FO"),
			Country(countryName = "FR"),
			Country(countryName = "GA"),
			Country(countryName = "GD"),
			Country(countryName = "GE"),
			Country(countryName = "GF"),
			Country(countryName = "GH"),
			Country(countryName = "GI"),
			Country(countryName = "GL"),
			Country(countryName = "GM"),
			Country(countryName = "GN"),
			Country(countryName = "GP"),
			Country(countryName = "GQ"),
			Country(countryName = "GR"),
			Country(countryName = "GS"),
			Country(countryName = "GT"),
			Country(countryName = "GU"),
			Country(countryName = "GW"),
			Country(countryName = "GY"),
			Country(countryName = "HK"),
			Country(countryName = "HM"),
			Country(countryName = "HN"),
			Country(countryName = "HR"),
			Country(countryName = "HT"),
			Country(countryName = "HU"),
			Country(countryName = "IC"),
			Country(countryName = "ID"),
			Country(countryName = "IE"),
			Country(countryName = "IL"),
			Country(countryName = "IM"),
			Country(countryName = "IN"),
			Country(countryName = "IO"),
			Country(countryName = "IQ"),
			Country(countryName = "IR"),
			Country(countryName = "IS"),
			Country(countryName = "IT"),
			Country(countryName = "JM"),
			Country(countryName = "JO"),
			Country(countryName = "JP"),
			Country(countryName = "KE"),
			Country(countryName = "KG"),
			Country(countryName = "KH"),
			Country(countryName = "KI"),
			Country(countryName = "KM"),
			Country(countryName = "KN"),
			Country(countryName = "KP"),
			Country(countryName = "KR"),
			Country(countryName = "LA"),
			Country(countryName = "LB"),
			Country(countryName = "LC"),
			Country(countryName = "LI"),
			Country(countryName = "LK"),
			Country(countryName = "LR"),
			Country(countryName = "LS"),
			Country(countryName = "LT"),
			Country(countryName = "LU"),
			Country(countryName = "LV"),
			Country(countryName = "LY"),
			Country(countryName = "MA"),
			Country(countryName = "MC"),
			Country(countryName = "ME"),
			Country(countryName = "MG"),
			Country(countryName = "MH"),
			Country(countryName = "MK"),
			Country(countryName = "ML"),
			Country(countryName = "MM"),
			Country(countryName = "MN"),
			Country(countryName = "MO"),
			Country(countryName = "MP"),
			Country(countryName = "MQ"),
			Country(countryName = "MR"),
			Country(countryName = "MS"),
			Country(countryName = "MT"),
			Country(countryName = "MU"),
			Country(countryName = "MV"),
			Country(countryName = "MW"),
			Country(countryName = "MX"),
			Country(countryName = "MY"),
			Country(countryName = "MZ"),
			Country(countryName = "NA"),
			Country(countryName = "NC"),
			Country(countryName = "NE"),
			Country(countryName = "NF"),
			Country(countryName = "NG"),
			Country(countryName = "NI"),
			Country(countryName = "NL"),
			Country(countryName = "NO"),
			Country(countryName = "NP"),
			Country(countryName = "NR"),
			Country(countryName = "NU"),
			Country(countryName = "NZ"),
			Country(countryName = "OM"),
			Country(countryName = "PA"),
			Country(countryName = "PE"),
			Country(countryName = "PF"),
			Country(countryName = "PG"),
			Country(countryName = "PH"),
			Country(countryName = "PK"),
			Country(countryName = "PL"),
			Country(countryName = "PM"),
			Country(countryName = "PN"),
			Country(countryName = "PR"),
			Country(countryName = "PS"),
			Country(countryName = "PT"),
			Country(countryName = "PW"),
			Country(countryName = "PY"),
			Country(countryName = "QA"),
			Country(countryName = "RE"),
			Country(countryName = "RO"),
			Country(countryName = "RS"),
			Country(countryName = "RU"),
			Country(countryName = "RW"),
			Country(countryName = "SA"),
			Country(countryName = "SB"),
			Country(countryName = "SC"),
			Country(countryName = "SD"),
			Country(countryName = "SE"),
			Country(countryName = "SG"),
			Country(countryName = "SH"),
			Country(countryName = "SI"),
			Country(countryName = "SJ"),
			Country(countryName = "SK"),
			Country(countryName = "SL"),
			Country(countryName = "SM"),
			Country(countryName = "SN"),
			Country(countryName = "SO"),
			Country(countryName = "SR"),
			Country(countryName = "SS"),
			Country(countryName = "ST"),
			Country(countryName = "SU"),
			Country(countryName = "SV"),
			Country(countryName = "SX"),
			Country(countryName = "SY"),
			Country(countryName = "SZ"),
			Country(countryName = "TC"),
			Country(countryName = "TD"),
			Country(countryName = "TF"),
			Country(countryName = "TG"),
			Country(countryName = "TH"),
			Country(countryName = "TJ"),
			Country(countryName = "TK"),
			Country(countryName = "TM"),
			Country(countryName = "TN"),
			Country(countryName = "TO"),
			Country(countryName = "TR"),
			Country(countryName = "TT"),
			Country(countryName = "TV"),
			Country(countryName = "TW"),
			Country(countryName = "TZ"),
			Country(countryName = "UA"),
			Country(countryName = "UG"),
			Country(countryName = "UM"),
			Country(countryName = "US"),
			Country(countryName = "UY"),
			Country(countryName = "UZ"),
			Country(countryName = "VA"),
			Country(countryName = "VC"),
			Country(countryName = "VE"),
			Country(countryName = "VG"),
			Country(countryName = "VI"),
			Country(countryName = "VN"),
			Country(countryName = "VU"),
			Country(countryName = "WF"),
			Country(countryName = "WS"),
			Country(countryName = "YE"),
			Country(countryName = "YT"),
			Country(countryName = "ZA"),
			Country(countryName = "ZM"),
			Country(countryName = "ZW"),
		)

		val countriesFromDB = countryRepository.findAll().map { it.countryName }

		countriesFromDB.forEach { countryDB ->
			countries.removeIf { countryDB.equals(it.countryName) }
		}

		countryRepository.saveAll(countries)
	}
}
