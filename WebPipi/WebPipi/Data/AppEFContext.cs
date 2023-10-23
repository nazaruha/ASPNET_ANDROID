using Microsoft.EntityFrameworkCore;
using WebPipi.Data.Entities;

namespace WebPipi.Data
{
    public class AppEFContext : DbContext
    {
        public AppEFContext(DbContextOptions<AppEFContext> options) : base(options)
        {

        }
        public DbSet<CategoryEntity> Categories { get; set; }
    }
}
