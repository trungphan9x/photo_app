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
            description = "I love Adele"
        ),
        PhotoDetailEntity(
            id = 2,
            name = "Bill Gate",
            urlPhoto = "https://vcdn-giadinh.vnecdn.net/2019/04/17/sam-5028-1555475169.jpg",
            description = "I love Bill"
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