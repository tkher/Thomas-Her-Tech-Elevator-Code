let bookmarkService = {
  allBookmarks: [
    {
      "bookmarkId": 1,
      "title": "Step by Step Resume Guide",
      "url": "https://www.themuse.com/advice/how-to-make-a-resume-examples",
      "description": "Nice step by step resume guide with examples.",
    },
    {
      "bookmarkId": 2,
      "title": "Create a Good LinkedIn Profile",
      "url": "https://www.linkedin.com/help/linkedin/answer/a554351/how-do-i-create-a-good-linkedin-profile",
      "description": "Tips for creating a solid LinkedIn profile for job hunting.",
    },
    {
      "bookmarkId": 3,
      "title": "huntr",
      "url": "https://huntr.co/",
      "description": "Awesome website for tracking job applications."
    },
    {
      "bookmarkId": 4,
      "title": "Developer Networking Site",
      "url": "https://www.invisiblenetwork.com/",
      "description": "Networking with double opt-in introductions."
    },
    {
      "bookmarkId": 5,
      "title": "Good Imposter Syndrome Article",
      "url": "https://www.themuse.com/advice/5-different-types-of-imposter-syndrome-and-5-ways-to-battle-each-one",
      "description": ""
    },
  ],

  getBookmarks() {
    return this.allBookmarks;
  },

  getBookmarkById(bookmarkId) {
    return this.allBookmarks.find( (p) => {
      return p.bookmarkId === bookmarkId;
    });
  },

  searchBookmarks (title) {
    return this.allBookmarks.filter( (p) => {
      return !title || p.title.toLowerCase().includes(title.toLowerCase());
    });
  },
};
