var app = new Vue({
    el: "#id-container",
    data: {
		msg: 'test',
      	notifications: [],
      	tags: [],
		cats: [],
		viewMode: [],
		post: []
    },
	methods: {
		dataLoading: function () {
			var self = this;

			Func.loadMainNotification(function(data){
				self.notifications = data;
			});

			Func.loadTags(function(data){
				self.tags = data;
			});
			Func.loadCats(function(data){
				self.cats = data;
			});
			Func.loadFilterMode(function(data){
				self.viewMode = data;
			});
			Func.loadPost(function(data){
				self.post = data;
			});
		},
		dropdown(data, e){
			Func.dropdown(data, e);

	        e.preventDefault();
	        return false;
		},
		openMobileSearch(e){
			Func.openMobileSearch(e);
			e.preventDefault();
	        return false;
		},
		dropdownSelect(e){
			Func.dropdownSelect(e);
			e.preventDefault();
	        return false;
		},
		modeFilter(e){
			Func.modeFilter(e);
			e.preventDefault();
	        return false;
		}
	},
	mounted: function(){
		var self = this;
		self.dataLoading();
	}
});