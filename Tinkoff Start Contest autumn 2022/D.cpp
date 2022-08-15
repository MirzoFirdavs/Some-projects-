#include <iostream>
#include <map>

void rec(std::map<std::string, int> m) {
    std::string s;
    std::map<std::string, int> new_map = std::move(m);

    while (std::cin >> s) {
        if (s == "{") {
            rec(new_map);
        } else if (s == "}") {
            return;
        } else {
            std::string first = s.substr(0, s.find('='));
            std::string second = s.substr(s.find('=') + 1, s.size());

            if (std::isdigit(second[0]) or second[0] == '-') {
                int num = std::stoi(second);

                new_map[first] = num;
            } else {
                if (new_map.count(second) > 0) {
                    new_map[first] = new_map[second];
                } else {
                    new_map[first] = 0;
                }

                std::cout << new_map[first] << '\n;
            }
        }
    }
}

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    
    std::map<std::string, int> m;
    
    rec(m);

    return 0;
}