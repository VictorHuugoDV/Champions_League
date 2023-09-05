package com.example.champions_league

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.champions_league.data.DataSource
import com.example.champions_league.model.Data
import com.example.champions_league.ui.theme.Champions_LeagueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Champions_LeagueTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TitleData()
                }
            }
        }
    }
}

@Composable
fun TitleData() {
    Column {
        Text(text = stringResource(id = R.string.champions_league), fontSize = 20.sp,
        modifier = Modifier
        )
        DataList(list = DataSource().loandDatas())
    }
}

@Composable
fun CardData(times: Data) {
    Card(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Row() {
            Box() {
                Image(
                    painter = painterResource(id = times.imagemTime),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 78.dp, height = 78.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }
            Column() {
                Text(
                    text = stringResource(id = times.nomeTime),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(
                            top = dimensionResource(id = R.dimen.padding_medium),
                            start = dimensionResource(id = R.dimen.padding_small),
                            end = dimensionResource(id = R.dimen.padding_small)
                        )
                )
                Row() {

                    Icon(
                        painter = painterResource(id = R.drawable.icons8_trophy_48),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .padding(
                                start = dimensionResource(id = R.dimen.padding_medium),
                                top = dimensionResource(id = R.dimen.padding_small)
                            )
                    )


                    Text(
                        text = stringResource(id = times.titulos),
                        modifier = Modifier
                            .padding(
                                start = dimensionResource(id = R.dimen.padding_medium),
                                top = dimensionResource(id = R.dimen.padding_small)
                            )
                    )
                }
            }
        }
    }
}
@Composable
fun DataList(list:List<Data>){
    LazyVerticalGrid(columns =GridCells.Fixed(2)){
        items(list){list->
            CardData(times = list)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Champions_LeagueTheme {
        CardData(Data(R.drawable.reall, R.string.equipe_1, R.string.titulos_1))
    }
}