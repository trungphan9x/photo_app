package com.trung.photoapp.ui.fragment.listphoto.listphoto1

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.trung.photoapp.core.BaseViewModel
import com.trung.photoapp.data.PhotoRoomRepository
import com.trung.photoapp.data.db.entity.PhotoDetailEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListAViewModel(private val photoRoomRepository: PhotoRoomRepository) : BaseViewModel() {
    var allPhoto: LiveData<List<PhotoDetailEntity>> = photoRoomRepository.allAlphabetizedPhoto

    private val listPhotoInserted = arrayListOf<PhotoDetailEntity>(
        PhotoDetailEntity(
            id = 1,
            name = "Adele",
            urlPhoto = "https://www.insidehook.com/wp-content/uploads/2020/05/GettyImages-518037594.jpg?fit=1800%2C1198",
            description = "Adele Laurie Blue Adkins MBE (/əˈdɛl/; born 5 May 1988) is an English singer-songwriter. After graduating from the BRIT School in 2006, Adele signed a recording contract with XL Recordings. In 2007, she received the Brit Awards Critics' Choice Award and won the BBC Sound of 2008 poll. Her debut album, 19, was released in 2008 to commercial and critical success. It is certified eight times platinum in the UK, and three times platinum in the US. The album contains her first song, \"Hometown Glory\", written when she was 16, which is based on her home suburb of West Norwood in London. An appearance she made on Saturday Night Live in late 2008 boosted her career in the US. At the 51st Grammy Awards in 2009, Adele received the awards for Best New Artist and Best Female Pop Vocal Performance.\n" +
                    "\n" +
                    "Adele released her second studio album, 21, in 2011. The album was critically well received and surpassed the success of her debut, earning numerous awards in 2012, among them a record-tying six Grammy Awards, including Album of the Year; two Brit Awards, including British Album of the Year; and three American Music Awards, including Favorite Pop/Rock Album. The album has been certified 17 times platinum in the UK, and is overall the fourth best-selling album in the nation. In the US, it has held the top position longer than any album since 1985, and is certified diamond. The best-selling album worldwide of 2011 and 2012, 21 has sold over 31 million copies. The success of 21 earned Adele numerous mentions in the Guinness Book of World Records. She was the first female artist to simultaneously have two albums in the top five of the Billboard 200 and two singles in the top five of the Billboard Hot 100, as well as the first woman in the history of the Billboard Hot 100 to have three simultaneous top 10 singles as a lead artist, with \"Rolling in the Deep\", \"Someone Like You\", and \"Set Fire to the Rain\", all of which also topped the chart. 21 is the longest-running number one album by a female solo artist in the history of the UK and US Album Charts.\n" +
                    "\n" +
                    "In 2012, Adele released \"Skyfall\", which she co-wrote and recorded for the James Bond film of the same name. The song won an Academy Award, a Grammy Award, and a Golden Globe for Best Original Song, as well as the Brit Award for British Single of the Year. After taking a three-year break, Adele released her third studio album, 25, in 2015. It became the year's best-selling album and broke first-week sales records in the UK and US. 25 was her second album to be certified diamond in the US and earned her five Grammy Awards, including Album of the Year, and four Brit Awards, including British Album of the Year. The lead single, \"Hello\", became the first song in the US to sell over one million digital copies within a week of its release. Her third concert tour, Adele Live 2016, visited Europe, North America and Oceania, and concluded with finale concerts at Wembley Stadium in late June 2017.[7]\n" +
                    "\n" +
                    "In 2011, 2012, and 2016, Adele was named Artist of the Year by Billboard. At the 2012 and 2016 Ivor Novello Awards, Adele was named Songwriter of the Year by the British Academy of Songwriters, Composers, and Authors. In 2012, she was listed at number five on VH1's 100 Greatest Women in Music. Time magazine named her one of the most influential people in the world in 2012 and 2016. Her 2016–2017 tour, saw her break attendance records in a number of countries, including the UK, Australia, and the US. With sales of more than 120 million records, Adele is one of the world's best-selling music artists.[8]"
        ),
        PhotoDetailEntity(
            id = 2,
            name = "Bill Gate",
            urlPhoto = "https://vcdn-giadinh.vnecdn.net/2019/04/17/sam-5028-1555475169.jpg",
            description = "William Henry Gates III (born October 28, 1955) is an American business magnate, software developer, investor, and philanthropist. He is best known as the co-founder of Microsoft Corporation.[2][3] During his career at Microsoft, Gates held the positions of chairman, chief executive officer (CEO), president and chief software architect, while also being the largest individual shareholder until May 2014. He is one of the best-known entrepreneurs and pioneers of the microcomputer revolution of the 1970s and 1980s.\n" +
                    "\n" +
                    "Born and raised in Seattle, Washington, Gates co-founded Microsoft with childhood friend Paul Allen in 1975, in Albuquerque, New Mexico; it went on to become the world's largest personal computer software company.[4][a] Gates led the company as chairman and CEO until stepping down as CEO in January 2000, but he remained chairman and became chief software architect.[7] During the late 1990s, Gates had been criticized for his business tactics, which have been considered anti-competitive. This opinion has been upheld by numerous court rulings.[8] In June 2006, Gates announced that he would be transitioning to a part-time role at Microsoft and full-time work at the Bill & Melinda Gates Foundation, the private charitable foundation that he and his wife, Melinda Gates, established in 2000.[9] He gradually transferred his duties to Ray Ozzie and Craig Mundie.[10] He stepped down as chairman of Microsoft in February 2014 and assumed a new post as technology adviser to support the newly appointed CEO Satya Nadella.[11]\n" +
                    "\n" +
                    "Since 1987, he has been included in the Forbes list of the world's wealthiest people.[12][13] From 1995 to 2017, he held the Forbes title of the richest person in the world all but four of those years.[1] In October 2017, he was surpassed by Amazon founder and CEO Jeff Bezos, who had an estimated net worth of US\$90.6 billion compared to Gates' net worth of US\$89.9 billion at the time.[14] As of November 2019, Gates had an estimated net worth of US\$107.1 billion, making him the second-wealthiest person in the world, behind Bezos.[b]\n" +
                    "\n" +
                    "Later in his career and since leaving day-to-day operations at Microsoft in 2008, Gates pursued a number of philanthropic endeavors. He donated large amounts of money to various charitable organizations and scientific research programs through the Bill & Melinda Gates Foundation, reported to be the world's largest private charity.[16] In 2009, Gates and Warren Buffett founded The Giving Pledge, whereby they and other billionaires pledge to give at least half of their wealth to philanthropy.[17] The foundation says that it works to save lives and improve global health, and is working with Rotary International to eliminate polio.[18]"
        ),
        PhotoDetailEntity(
            id = 3,
            name = "Steve Jobs",
            urlPhoto = "https://st.quantrimang.com/photos/image/012013/29/stevejobs.jpg",
            description = "I love you"
        ),
        PhotoDetailEntity(
            id = 4,
            name = "Jack Ma",
            urlPhoto = "https://thumbor.forbes.com/thumbor/fit-in/416x416/filters%3Aformat%28jpg%29/https%3A%2F%2Fspecials-images.forbesimg.com%2Fimageserve%2F5e75465a10380d0006bdcb9f%2F0x0.jpg%3Fbackground%3D000000%26cropX1%3D1089%26cropX2%3D2195%26cropY1%3D4%26cropY2%3D1109",
            description = "I love you"
        ),
        PhotoDetailEntity(
            id = 5,
            name = "BTS",
            urlPhoto = "https://www.cheatsheet.com/wp-content/uploads/2020/05/BTS-band.jpg",
            description = "I love youI love you"
        ),
        PhotoDetailEntity(
            id = 6,
            name = "ABBA",
            urlPhoto = "https://cdnmedia.thethaovanhoa.vn/Upload/leenEplQKY7jsunvYUYgg/files/2020/05/abba1.jpg",
            description = "I love youI love youI love youI love you"
        ),
        PhotoDetailEntity(
            id = 7,
            name = "Michael Jackson",
            urlPhoto = "https://www.biography.com/.image/t_share/MTE1ODA0OTcxMjkwNTYwMDEz/michael-jackson-pepsi-commercial-raw.jpg",
            description = "I love youI love youI love youI love youI love you"
        ),
        PhotoDetailEntity(
            id = 8,
            name = "taylor swift",
            urlPhoto = "https://cdn.vox-cdn.com/thumbor/sKobvhE31vUDeQrW_WNKH0MKQUo=/1400x1400/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/19378373/1164343509.jpg.jpg",
            description = "I love youI love youI love youI love you"
        ),
        PhotoDetailEntity(
            id = 9,
            name = "Son Tung MTP",
            urlPhoto = "https://www.sbs.com.au/popasia/sites/sbs.com.au.popasia/files/sontungmtp.png",
            description = "I love you"
        ),
        PhotoDetailEntity(
            id = 10,
            name = "Bich Phuong",
            urlPhoto = "https://i.ytimg.com/vi/ZF3b1nK-TjM/maxresdefault.jpg",
            description = "I love youI love youI love you"
        ),
        PhotoDetailEntity(
            id = 11,
            name = "Trump",
            urlPhoto = "https://pmcdeadline2.files.wordpress.com/2019/10/shutterstock_editorial_10434333bm.jpg",
            description = "I love youI love youI love youI love you"
        ),
        PhotoDetailEntity(
            id = 12,
            name = "hillary clinton",
            urlPhoto = "https://i.guim.co.uk/img/media/6ede975e12b9a69dfa85868e3eae9f6d2a35fe00/0_106_4445_2668/master/4445.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=128f856b0840d52fb4f55808000606f3",
            description = "I love youI love youI love youI love you"
        ),
        PhotoDetailEntity(
            id = 13,
            name = "john f kennedy",
            urlPhoto = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/John_F._Kennedy%2C_White_House_color_photo_portrait.jpg/1200px-John_F._Kennedy%2C_White_House_color_photo_portrait.jpg",
            description = "I love youI love youI love youI love youI love youI love you"
        ),
        PhotoDetailEntity(
            id = 14,
            name = "Mun Jae In",
            urlPhoto = "https://upload.wikimedia.org/wikipedia/commons/c/c9/Moon_Jae-in_%282017-10-01%29_cropped.jpg",
            description = "I love youI love youI love youI love youI love you"
        ),
        PhotoDetailEntity(
            id = 15,
            name = "My Tam",
            urlPhoto = "https://nld.mediacdn.vn/2018/2/3/13-chot-15176700723471428987902.jpg",
            description = "I love youI love you"
        ),
        PhotoDetailEntity(
            id = 16,
            name = "Ho Ngoc Ha",
            urlPhoto = "https://media.tinmoi.vn/upload/camnhung/2020/05/23/141208-ho-ngoc-ha-bi-choi-xau-tm1.jpg",
            description = "I love youI love youI love youI love you"
        ),
        PhotoDetailEntity(
            id = 17,
            name = "one direction",
            urlPhoto = "https://www.spectatornews.com/wp-content/uploads/2020/04/WEB_1DReunion_Submitted-900x506.jpg",
            description = "I love youI love youI love you"
        ),
        PhotoDetailEntity(
            id = 18,
            name = "kelly clarkson",
            urlPhoto = "https://akns-images.eonline.com/eol_images/Entire_Site/201984/rs_600x600-190904154151-600-the-kelly-clarkson-show.jpg?fit=around|1200:1200&crop=1200:1200;center,top&output-quality=90",
            description = "I love youI love youI love you"
        )
    )

    init {
        insertAll(listPhotoInserted)
    }

    fun insert(photoDetailEntity: PhotoDetailEntity) = viewModelScope.launch(Dispatchers.IO) {
        photoRoomRepository.insert(photoDetailEntity)
    }

    fun insertAll(listPhoto: List<PhotoDetailEntity>) = viewModelScope.launch(Dispatchers.IO) {
        photoRoomRepository.insertAll(listPhoto).let {
            allPhoto = photoRoomRepository.allAlphabetizedPhoto
        }
    }
}