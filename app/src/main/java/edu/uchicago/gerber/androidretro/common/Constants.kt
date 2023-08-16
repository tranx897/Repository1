package edu.uchicago.gerber.androidretro.common

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.gson.Gson
import edu.uchicago.gerber.androidretro.data.dto.FavoriteMovieResponse
import edu.uchicago.gerber.androidretro.data.dto.Movie
import edu.uchicago.gerber.androidretro.data.models.Result
import edu.uchicago.gerber.androidretro.data.models.MovieResponse


object Constants {

    val modifier = Modifier.padding(paddingValues = PaddingValues(all = 0.dp))

    val movieUrl = "https://moviesdatabase.p.rapidapi.com/"
    val fakeMovie: Result
    val fakeResponse: MovieResponse

    val favoriteMovieUrl = "https://tranx897-service-1.4eedj6bmak670.us-west-2.cs.amazonlightsail.com/"

    val samEmailerUrl = "https://ylukoj8gi3.execute-api.us-west-2.amazonaws.com/Prod/"

    //use init to parse the raw response-body
    init {
        val gson = Gson()
        val hardCodedResponse = """
{
    "page": 1,
    "next": "/titles/search/keyword/batman?page=2",
    "entries": 10,
    "results": [
        {
            "_id": "61e580d28a5a6a599f414831",
            "id": "tt0063304",
            "primaryImage": {
                "id": "rm2313034752",
                "width": 400,
                "height": 548,
                "url": "https://m.media-amazon.com/images/M/MV5BYWVhYTczNmMtNzEzNS00YjI1LTk3YmYtYzcwZWJiNzcyMWFjXkEyXkFqcGdeQXVyNDUxNjc5NjY@._V1_.jpg",
                "caption": {
                    "plainText": "Min søsters børn vælter byen (1968)",
                    "__typename": "Markdown"
                },
                "__typename": "Image"
            },
            "titleType": {
                "text": "Movie",
                "id": "movie",
                "isSeries": false,
                "isEpisode": false,
                "__typename": "TitleType"
            },
            "titleText": {
                "text": "Min søsters børn vælter byen",
                "__typename": "TitleText"
            },
            "originalTitleText": {
                "text": "Min søsters børn vælter byen",
                "__typename": "TitleText"
            },
            "releaseYear": {
                "year": 1968,
                "endYear": null,
                "__typename": "YearRange"
            },
            "releaseDate": {
                "day": 11,
                "month": 10,
                "year": 1968,
                "__typename": "ReleaseDate"
            }
        },
        {
            "_id": "61e5815ea66e59642341611b",
            "id": "tt0102027",
            "primaryImage": {
                "id": "rm4095319808",
                "width": 279,
                "height": 475,
                "url": "https://m.media-amazon.com/images/M/MV5BMTg2MTAxMzEyN15BMl5BanBnXkFtZTcwNzcxMTcxMQ@@._V1_.jpg",
                "caption": {
                    "plainText": "Here's Looking at You, Warner Bros. (1991)",
                    "__typename": "Markdown"
                },
                "__typename": "Image"
            },
            "titleType": {
                "text": "TV Movie",
                "id": "tvMovie",
                "isSeries": false,
                "isEpisode": false,
                "__typename": "TitleType"
            },
            "titleText": {
                "text": "Here's Looking at You, Warner Bros.",
                "__typename": "TitleText"
            },
            "originalTitleText": {
                "text": "Here's Looking at You, Warner Bros.",
                "__typename": "TitleText"
            },
            "releaseYear": {
                "year": 1991,
                "endYear": null,
                "__typename": "YearRange"
            },
            "releaseDate": null
        },
        {
            "_id": "61e581bca66e59642341738b",
            "id": "tt0131960",
            "primaryImage": null,
            "titleType": {
                "text": "Video",
                "id": "video",
                "isSeries": false,
                "isEpisode": false,
                "__typename": "TitleType"
            },
            "titleText": {
                "text": "Batwoman & Catgirl",
                "__typename": "TitleText"
            },
            "originalTitleText": {
                "text": "Batwoman & Catgirl",
                "__typename": "TitleText"
            },
            "releaseYear": {
                "year": 1992,
                "endYear": null,
                "__typename": "YearRange"
            },
            "releaseDate": null
        },
        {
            "_id": "61e58fbdb597b91eb944b169",
            "id": "tt10764144",
            "primaryImage": {
                "id": "rm3667234049",
                "width": 4677,
                "height": 6614,
                "url": "https://m.media-amazon.com/images/M/MV5BNDdkZmMwNTgtNDYwNC00YjkwLWFhNjEtOWE1MDliZjg1NWZmXkEyXkFqcGdeQXVyMjIzOTc5Nzc@._V1_.jpg",
                "caption": {
                    "plainText": "Isabella Champagnie and Vincent Jerome in Living in Crime Alley (2019)",
                    "__typename": "Markdown"
                },
                "__typename": "Image"
            },
            "titleType": {
                "text": "Short",
                "id": "short",
                "isSeries": false,
                "isEpisode": false,
                "__typename": "TitleType"
            },
            "titleText": {
                "text": "Living in Crime Alley",
                "__typename": "TitleText"
            },
            "originalTitleText": {
                "text": "Living in Crime Alley",
                "__typename": "TitleText"
            },
            "releaseYear": {
                "year": 2019,
                "endYear": null,
                "__typename": "YearRange"
            },
            "releaseDate": {
                "day": 13,
                "month": 12,
                "year": 2019,
                "__typename": "ReleaseDate"
            }
        },
        {
            "_id": "61e593f3ef99b1c54345b94f",
            "id": "tt11478684",
            "primaryImage": {
                "id": "rm3837427713",
                "width": 1920,
                "height": 1080,
                "url": "https://m.media-amazon.com/images/M/MV5BYWFiN2MzMDgtODFjNS00NmRjLTk0MTEtYTZhMDI0MDQ2NGQ3XkEyXkFqcGdeQXVyNDc3MzQ5Nzc@._V1_.jpg",
                "caption": {
                    "plainText": "Andrew Bachelor, Rudy Mancuso, Lele Pons, Brock O'Hurn, and Anwar Jibawi in Superhero Therapy (2018)",
                    "__typename": "Markdown"
                },
                "__typename": "Image"
            },
            "titleType": {
                "text": "Short",
                "id": "short",
                "isSeries": false,
                "isEpisode": false,
                "__typename": "TitleType"
            },
            "titleText": {
                "text": "Superhero Therapy",
                "__typename": "TitleText"
            },
            "originalTitleText": {
                "text": "Superhero Therapy",
                "__typename": "TitleText"
            },
            "releaseYear": {
                "year": 2018,
                "endYear": null,
                "__typename": "YearRange"
            },
            "releaseDate": {
                "day": 10,
                "month": 10,
                "year": 2018,
                "__typename": "ReleaseDate"
            }
        },
        {
            "_id": "61e59424b597b91eb945c47f",
            "id": "tt11509646",
            "primaryImage": null,
            "titleType": {
                "text": "TV Mini Series",
                "id": "tvMiniSeries",
                "isSeries": true,
                "isEpisode": false,
                "__typename": "TitleType"
            },
            "titleText": {
                "text": "OnStar: Batman",
                "__typename": "TitleText"
            },
            "originalTitleText": {
                "text": "OnStar: Batman",
                "__typename": "TitleText"
            },
            "releaseYear": {
                "year": 2000,
                "endYear": 2002,
                "__typename": "YearRange"
            },
            "releaseDate": {
                "day": 28,
                "month": 2,
                "year": 2000,
                "__typename": "ReleaseDate"
            }
        },
        {
            "_id": "61e595f8cffb8f2faa4638db",
            "id": "tt11821566",
            "primaryImage": {
                "id": "rm3526481409",
                "width": 1325,
                "height": 2048,
                "url": "https://m.media-amazon.com/images/M/MV5BMzRiYjQyM2UtNjI1OC00MTdhLWJlMGUtNzAwODZlMjU5ZmFiXkEyXkFqcGdeQXVyNzcwOTcwMjA@._V1_.jpg",
                "caption": {
                    "plainText": "The Devil's Daughter (2021)",
                    "__typename": "Markdown"
                },
                "__typename": "Image"
            },
            "titleType": {
                "text": "Movie",
                "id": "movie",
                "isSeries": false,
                "isEpisode": false,
                "__typename": "TitleType"
            },
            "titleText": {
                "text": "The Devil's Daughter",
                "__typename": "TitleText"
            },
            "originalTitleText": {
                "text": "The Devil's Daughter",
                "__typename": "TitleText"
            },
            "releaseYear": {
                "year": 2021,
                "endYear": null,
                "__typename": "YearRange"
            },
            "releaseDate": {
                "day": 30,
                "month": 10,
                "year": 2021,
                "__typename": "ReleaseDate"
            }
        },
        {
            "_id": "61e5971295801a78bc4681db",
            "id": "tt12011968",
            "primaryImage": {
                "id": "rm2896942593",
                "width": 1587,
                "height": 2245,
                "url": "https://m.media-amazon.com/images/M/MV5BMmYxZTUyYjQtNTIzMi00NjgyLWFlNDMtZTc5ZjA1NzY2M2Y1XkEyXkFqcGdeQXVyMTE5NTczMzUw._V1_.jpg",
                "caption": {
                    "plainText": "The Dark Omen (2020)",
                    "__typename": "Markdown"
                },
                "__typename": "Image"
            },
            "titleType": {
                "text": "Short",
                "id": "short",
                "isSeries": false,
                "isEpisode": false,
                "__typename": "TitleType"
            },
            "titleText": {
                "text": "The Dark Omen",
                "__typename": "TitleText"
            },
            "originalTitleText": {
                "text": "The Dark Omen",
                "__typename": "TitleText"
            },
            "releaseYear": {
                "year": 2020,
                "endYear": null,
                "__typename": "YearRange"
            },
            "releaseDate": {
                "day": 22,
                "month": 3,
                "year": 2020,
                "__typename": "ReleaseDate"
            }
        },
        {
            "_id": "61e59851d8f3c0931e46ceb3",
            "id": "tt12222638",
            "primaryImage": {
                "id": "rm1457788161",
                "width": 1363,
                "height": 2000,
                "url": "https://m.media-amazon.com/images/M/MV5BYmIwZThlZGQtYzQxNC00MDFlLWExYmQtNGU1N2RhZjM4YmVhXkEyXkFqcGdeQXVyMzM1MTIxOTM@._V1_.jpg",
                "caption": {
                    "plainText": "Aundrea Brown and Curtis K Case in Spellbinder Shadow (2022)",
                    "__typename": "Markdown"
                },
                "__typename": "Image"
            },
            "titleType": {
                "text": "Short",
                "id": "short",
                "isSeries": false,
                "isEpisode": false,
                "categories": [
                    {
                        "value": "movie",
                        "__typename": "TitleTypeCategory"
                    }
                ],
                "canHaveEpisodes": false,
                "__typename": "TitleType"
            },
            "titleText": {
                "text": "Spellbinder Shadow",
                "__typename": "TitleText"
            },
            "originalTitleText": {
                "text": "Spellbinder Shadow",
                "__typename": "TitleText"
            },
            "releaseYear": {
                "year": 2022,
                "endYear": null,
                "__typename": "YearRange"
            },
            "releaseDate": {
                "day": 31,
                "month": 10,
                "year": 2022,
                "__typename": "ReleaseDate"
            }
        },
        {
            "_id": "61e5985ad8f3c0931e46d0b7",
            "id": "tt12233692",
            "primaryImage": null,
            "titleType": {
                "text": "TV Episode",
                "id": "tvEpisode",
                "isSeries": false,
                "isEpisode": true,
                "__typename": "TitleType"
            },
            "titleText": {
                "text": "BATMAN vs HALLOWEEN MICHAEL MYERS!! Joker, Harley Quinn, Batgirl Epic Horror Parody",
                "__typename": "TitleText"
            },
            "originalTitleText": {
                "text": "BATMAN vs HALLOWEEN MICHAEL MYERS!! Joker, Harley Quinn, Batgirl Epic Horror Parody",
                "__typename": "TitleText"
            },
            "releaseYear": {
                "year": 2018,
                "endYear": null,
                "__typename": "YearRange"
            },
            "releaseDate": {
                "day": 19,
                "month": 10,
                "year": 2018,
                "__typename": "ReleaseDate"
            }
        }
    ]
}
    """
        fakeResponse = gson.fromJson<MovieResponse>(hardCodedResponse, MovieResponse::class.java)
        fakeMovie = fakeResponse.results[0]

    }

}