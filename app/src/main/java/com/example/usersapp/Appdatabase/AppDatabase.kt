import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.usersapp.`interface`.PostDao
import com.example.usersapp.`interface`.UserDao
import com.example.usersapp.entitys.PostEntity
import com.example.usersapp.entitys.UserEntity

@Database(entities = [UserEntity::class, PostEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase(){
  //   abstract fun PostDao(): PostDao
   //  abstract fun UserDao(): UserDao

    companion object {
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            AppDatabase::class.java, "todo-list.db")
            .build()
    }
}