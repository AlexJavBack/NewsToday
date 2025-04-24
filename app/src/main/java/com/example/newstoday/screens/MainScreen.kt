@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.newstoday.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.newstoday.R
import com.example.newstoday.enums.Categorys
import com.example.newstoday.enums.CountryRu
import com.example.newstoday.enums.Countrys
import com.example.newstoday.enums.LanguageRu
import com.example.newstoday.enums.Languages
import com.example.newstoday.retrofit.GlobalNewsViewModel
import java.util.Locale

@Composable
fun ListItems(navController: NavController, screenVM: GlobalNewsViewModel) {
    var isExpandedCountry by remember {
        mutableStateOf(false)
    }
    var isExpandedCategory by remember {
        mutableStateOf(false)
    }
    var isExpandedLanguages by remember {
        mutableStateOf(false)
    }
    var country by remember {
        mutableStateOf("")
    }
    var category by remember {
        mutableStateOf("")
    }
    var languages by remember {
        mutableStateOf("")
    }
    val searchText = remember {
        mutableStateOf("")
    }
    var isActiveSearch by remember {
        mutableStateOf(true)
    }
    var isClickable by remember {
        mutableStateOf(false) }
    Column(modifier = Modifier
        .fillMaxHeight()
        .paint(
            painterResource(id = R.drawable.main_phone),
            contentScale = ContentScale.FillBounds
        )
    ) {
        SearchBar(
            enabled = isActiveSearch,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            query = searchText.value,
            onQueryChange = { text ->
                searchText.value = text
            },
            onSearch = {text ->
                screenVM.qu.value = text
                navController.navigate(Routes.GlobalNewsScreen.route)
            },
            placeholder = {
                Text(text = "Search")
            },
            active = false,
            onActiveChange = {
                false
            }
        ) {
        }
        Text(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 20.dp), textAlign = TextAlign.Center, fontSize = 20.sp, text = "Select the country whose news you want to know.", color = Color.Yellow )
        ExposedDropdownMenuBox(expanded = isExpandedCountry,
            onExpandedChange = {isExpandedCountry = it}) {
            TextField(value = country,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpandedCountry) },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth())
            ExposedDropdownMenu(expanded = isExpandedCountry,
                onDismissRequest = {isExpandedCountry = false} ) {
                when(Locale.getDefault().language){
                    "en" -> for(i in Countrys.entries) {
                        DropdownMenuItem(text = {
                            Text(text = i.name)},
                            onClick = {
                                country = i.name
                                screenVM.country.value =
                                    Locale.getISOCountries().find { Locale("", it).displayCountry == i.name }!!
                                isExpandedCountry = false
                                isClickable = true
                                isActiveSearch = false
                            })
                    }
                    "ru" -> for(i in CountryRu.entries) {
                        DropdownMenuItem(text = {
                            Text(text = getCountryFullName(i.name))},
                            onClick = {
                                country = i.name
                                screenVM.country.value =
                                    Locale.getISOCountries().find { Locale("", it).displayCountry == i.name }!!
                                isExpandedCountry = false
                                isClickable = true
                                isActiveSearch = false
                            })
                    }
                }
            }
        }
        Text(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 20.dp), textAlign = TextAlign.Center, fontSize = 20.sp, text = "Select news category", color = Color.Yellow )
        ExposedDropdownMenuBox(expanded = isExpandedCategory,
            onExpandedChange = {isExpandedCategory = it}) {
            TextField(value = category,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpandedCategory) },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth())
            ExposedDropdownMenu(expanded = isExpandedCategory,
                onDismissRequest = {isExpandedCategory = false} ) {
                for(i in Categorys.entries) {
                    DropdownMenuItem(text = {
                        Text(text = i.name)},
                        onClick = {
                            category = i.name
                            screenVM.category.value = i.name
                            isExpandedCategory = false
                            isClickable = true
                            isActiveSearch = false
                        })
                }

            }
        }
        Text(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 20.dp), textAlign = TextAlign.Center, fontSize = 20.sp, text = "Select the language in which the news will be displayed", color = Color.Yellow )
        ExposedDropdownMenuBox(expanded = isExpandedLanguages,
            onExpandedChange = {isExpandedLanguages = it}) {
            TextField(value = languages,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpandedLanguages) },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth())
            ExposedDropdownMenu(expanded = isExpandedLanguages,
                onDismissRequest = {isExpandedLanguages = false} ) {
                when(Locale.getDefault().language) {
                    "en" -> for(i in Languages.entries) {
                        DropdownMenuItem(text = {
                            Text(text = i.name)},
                            onClick = {
                                languages = i.name
                                screenVM.language.value =
                                    Locale.getISOLanguages().find { Locale(it, "").displayLanguage == i.name}!!
                                isExpandedLanguages = false
                                isClickable = true
                            })
                    }
                    "ru" -> for(i in LanguageRu.entries) {
                        DropdownMenuItem(text = {
                            Text(text = i.name)},
                            onClick = {
                                languages = i.name
                                screenVM.language.value =
                                    Locale.getISOLanguages().find { Locale(it, "").displayLanguage == i.name}!!
                                isExpandedLanguages = false
                                isClickable = true
                                isActiveSearch = false
                            })
                    }
                }
            }
        }
        Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center) {
            Button(colors = ButtonDefaults.buttonColors(contentColor = Color.Black, containerColor = Color.Yellow),
                onClick = {
                    screenVM.mainScreenGlobalNewsTextButton.value = "GlobalNews"
                    navController.navigate(Routes.GlobalNewsScreen.route)
                },
                enabled = isClickable,
                modifier = Modifier
                    .padding(bottom = 50.dp)
                    .sizeIn(minHeight = 60.dp)
            ) {
                Text("Search", fontSize = 24.sp)
            }
        }
    }
}
fun getCountryFullName(country :String) : String {
    val listconnt = country.split("(?=[А-Я])".toRegex())
    val name = java.lang.String.join(" ", listconnt)
    return name
}
