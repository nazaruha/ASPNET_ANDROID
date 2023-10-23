using AutoMapper;
using WebPipi.Data.Entities;
using WebPipi.Models.Category;

namespace WebPipi.Mapper
{
    public class AppMapProfile : Profile
    {
        public AppMapProfile()
        {
            CreateMap<CategoryEntity, CategoryItemViewModel>().ReverseMap();
            CreateMap<CategoryEntity, CategoryCreateViewModel>().ReverseMap();
        }

    }
}
