package com.example.incrediblecompose.ui.countryDetails

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.incrediblecompose.domain.model.CountryDetails
import com.example.incrediblecompose.domain.model.Language
import com.example.incrediblecompose.domain.model.Vaccination
import com.google.accompanist.flowlayout.FlowRow


@Composable
fun CountryHeader(countyDetails: CountryDetails) {

    Text(
        text = countyDetails.names.full,
        style = TextStyle(color = Color.Black, fontSize = 40.sp, fontWeight = FontWeight.ExtraBold),
        modifier = Modifier.padding(8.dp)
    )

    Row(horizontalArrangement = Arrangement.SpaceEvenly) {

        Text(
            text = "Continent:" + countyDetails.names.continent,
            style = TextStyle(
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier.padding(8.dp)

        )
        Text(
            text = "TimeZone: " + countyDetails.timezone.name,
            style = TextStyle(
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier.padding(8.dp)
        )


        Text(
            text = "Telephone",
            style = TextStyle(
                color = Color.Black,
                fontSize = 40.sp,
                fontWeight = FontWeight.ExtraBold
            ),
            modifier = Modifier.padding(12.dp)

        )


        Text(
            text = "Ambulance: ${countyDetails.telephone.ambulance}",
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            ),
            modifier = Modifier.padding(horizontal = 12.dp)
        )

        Text(
            text = "Calling Code: ${countyDetails.telephone.calling_code}",
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            ),
            modifier = Modifier.padding(horizontal = 12.dp)
        )

        Text(
            text = "Police: ${countyDetails.telephone.police}",
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            ),
            modifier = Modifier.padding(horizontal = 12.dp)
        )

        Text(
            text = "Fire: ${countyDetails.telephone.fire}",
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            ),
            modifier = Modifier.padding(horizontal = 12.dp)
        )
    }


    @Composable
    fun LanguageComp(language: List<Language>) {
        Text(
            text = "Languages",
            style = TextStyle(
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold
            ),
            modifier = Modifier.padding(12.dp)
        )

        FlowRow {
            language.forEach {
                LanguageItem(language = it)

            }
        }


    }
}

@Composable
fun LanguageItem(language: Language) {
    Card(
        modifier = Modifier
            .padding(12.dp)
            .wrapContentSize(),
        shape = RoundedCornerShape(100.dp),
        border = BorderStroke(1.dp, color = Color.Black)
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = language.language,
            style = TextStyle(color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Normal)
        )
    }

}

@Composable
fun VaccinationComponent(vaccination: List<Vaccination>) {

    Text(
        text = "Vaccinations",
        style = TextStyle(color = Color.Black, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold),
        modifier = Modifier.padding(12.dp)
    )

    vaccination.forEach {
        VaccinationItem(vaccination = it)
    }

}

@Composable
fun VaccinationItem(vaccination: Vaccination) {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .wrapContentSize(), shape = RoundedCornerShape(12.dp)
    ) {

        Column(modifier = Modifier.padding(4.dp)) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = vaccination.name,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                textDecoration = TextDecoration.Underline
            )

            Text(
                text = vaccination.message,
                modifier = Modifier.padding(4.dp),
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp
                ), maxLines = 4, overflow = TextOverflow.Ellipsis
            )
        }
    }

}
